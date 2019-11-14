### 准备工作
1. 安装好VMware以及linux os
2. 配置到vm的静态ip（可选），参考[VMware+CentOS静态IP设置](https://blog.csdn.net/nidagewcc/article/details/102970267)
3. 下载安装redis，具体步骤（[CentOS7安装Redis单实例
 ](https://gper.club/articles/7e7e7f7ff7g5egc4g6b)）
4. 集群的另说（sentinel和cluster）


### Jedis Maven依赖

```xml
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>3.1.0</version>
    <type>jar</type>
    <scope>compile</scope>
</dependency>
```
*可以参考redis官网*

### jedis客户端的使用

- [x] 单机版基本的连接
- [ ] 基本工具类的封装
- [ ] 常用数据类型的基操（string、list、set、hash、sorted set等）
- [ ] 自定义客户端实现（可选）
- [ ] 管道pipeline的使用
- [ ] jedis实现分布式锁
- [ ] lua脚本使用
- [ ] 发布订阅
- [ ] 事务
- [x] sentinel
- [ ] cluster连接
- [ ] ...等等



### and so on...