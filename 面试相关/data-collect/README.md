### 逻辑梳理思路
1. 通万能的搜索引擎，查询到Linux系统实现cpu、内存、磁盘等监控信息，可以使用linux的proc文件系统中获得，但是由于解析文件中各项数据过于麻烦，
    所以使用了三方sigar包，不管是win，还是linux读取系统信息比较方便。
    
2. 下载的三方jar，放置在/resource/jar/hyperic-sigar-1.6.4.zip

3. 解压后将\hyperic-sigar-1.6.4\sigar-bin\lib目录中sigar包引入系统，获取系统参数的库文件，如
    sigar-amd64-winnt.dll、sigar-x86-winnt.dll、sigar-x86-winnt.lib等放入你的jdk文件夹的bin目录下，或者环境path配置的环境变量地址
    
4. 以上步骤完成，既可以通过sigar实例获取相应的系统参数了，具体请移步CollectService实现。


### 实现细节
1. 数据库使用的Mysql，初始化库表结构脚本和部分运行时跑的数据，在/resource/sql/collect.sql

2. 系统基于SpringBoot、MyBatis简单实现，详细依赖，请参考pom.xml

3. 任务调度使用了Spring自带的@Scheduled实现，每分钟执行一次

4. 启动服务后，任务自动执行，并存入db

5. 可访问http://localhost:8080/data-collect/refresh 查看数据

### 未实现部分

TODO: 前端部分想使用chart.js实现，但是最终未实现，尽力了。。。










