# RabbitMQ环境配置(Windows)



## 安装Erlang，下载地址：

https://www.erlang.org/downloads

一直下一步即可，可以自定义安装目录



## 安装RabbitMQ，下载地址：





## 进入RabbitMQ安装目录下的sbin目录

https://www.rabbitmq.com/install-windows.html

一直下一步即可，可以自定义安装目录



## 输入以下命令启动管理功能

rabbitmq-plugins enable rabbitmq_management

```shell
C:\Program Files\RabbitMQ Server\rabbitmq_server-3.9.16\sbin>rabbitmq-plugins enable rabbitmq_management
Enabling plugins on node rabbit@Y-PC:
rabbitmq_management
The following plugins have been configured:
  rabbitmq_management
  rabbitmq_management_agent
  rabbitmq_web_dispatch
Applying plugin configuration to rabbit@Y-PC...
The following plugins have been enabled:
  rabbitmq_management
  rabbitmq_management_agent
  rabbitmq_web_dispatch

started 3 plugins.

C:\Program Files\RabbitMQ Server\rabbitmq_server-3.9.16\sbin>
```







## 访问地址查看是否安装成功：

http://localhost:15672/



## 输入账号密码并登录：

guest guest