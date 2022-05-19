## Seata-Server安装

### 官网地址

http://seata.io/zh-cn/



### 下载版本

https://github.com/seata/seata/releases

下载的是seata-server-0.9.0.zip





### seata-server-0.9.0.zip解压到指定目录

并修改conf目录下的file.conf配置文件

​	先备份原始file.conf文件

​	主要修改：自定义事务组名称+事务日志存储模式为db+数据库连接信息

​	file.conf

```shell
store {
  ## store mode: file、db
  mode = "db"

  ## file store
  file {
    dir = "sessionStore"

    # branch session size , if exceeded first try compress lockkey, still exceeded throws exceptions
    max-branch-session-size = 16384
    # globe session size , if exceeded throws exceptions
    max-global-session-size = 512
    # file buffer size , if exceeded allocate new buffer
    file-write-buffer-cache-size = 16384
    # when recover batch read size
    session.reload.read_size = 100
    # async, sync
    flush-disk-mode = async
  }

  ## database store
  db {
    ## the implement of javax.sql.DataSource, such as DruidDataSource(druid)/BasicDataSource(dbcp) etc.
    datasource = "dbcp"
    ## mysql/oracle/h2/oceanbase etc.
    db-type = "mysql"
    driver-class-name = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1:3306/seata"
    user = "root"
    password = "你的密码"
    min-conn = 1
    max-conn = 3
    global.table = "global_table"
    branch.table = "branch_table"
    lock-table = "lock_table"
    query-limit = 100
  }
}
```



service模块:my_test_tx_group自定义

```shell
service {
  #vgroup->rgroup
  #vgroup_mapping.my_test_tx_group = "default"
  vgroup_mapping.my_test_tx_group = "fsp_tx_group"
  #only support single node
  default.grouplist = "127.0.0.1:8091"
  #degrade current not support
  enableDegrade = false
  #disable
  disable = false
  #unit ms,s,m,h,d represents milliseconds, seconds, minutes, hours, days, default permanent
  max.commit.retry.timeout = "-1"
  max.rollback.retry.timeout = "-1"
}
```





### mysql5.7数据库新建库seata

高版本需要对应的驱动，和seata版本

在seata库里建表

建表db_store.sql在\seata-server-0.9.0\seata\conf目录里面：db_store.sql





### 修改seata-server-0.9.0\seata\conf目录下的registry.conf配置文件



目的是：指明注册中心为nacos，及修改nacos连接信息

```shell
registry {
  # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "nacos"

  nacos {
    serverAddr = "localhost:8848"
	#serverAddr = "localhost"
    namespace = ""
    cluster = "default"
  }
 }
```



### 先启动Nacos端口号8848



### 再启动seata-server

softs\seata-server-0.9.0\seata\bin\seata-server.bat



我是jdk17，所以修改seata-server.bat的jdk版本

```she
if "%JAVACMD%"=="" set JAVACMD="C:\common\java\JDK\jdk8\bin\java.exe"

if "%REPO%"=="" set REPO=%BASEDIR%\lib
```

