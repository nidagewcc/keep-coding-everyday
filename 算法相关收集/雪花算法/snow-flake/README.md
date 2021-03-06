# 还没搞懂 - -

https://www.liaoxuefeng.com/article/1280526512029729#0

记录一下，面试x公司闻到这个问题，发现自己之前都研究过这个算法，然而并没有学会举一反三，面试问的时候脑子一片空白。


问题是：
    分布式唯一ID怎么生成？
    或者微服务uuid生成？


在应用程序中，经常需要全局唯一的ID作为数据库主键。如何生成全局唯一ID？

首先，需要确定全局唯一ID是整型还是字符串？如果是字符串，那么现有的UUID就完全满足需求，不需要额外的工作。缺点是字符串作为ID占用空间大，索引效率比整型低。

如果采用整型作为ID，那么首先排除掉32位int类型，因为范围太小，必须使用64位long型。

采用整型作为ID时，如何生成自增、全局唯一且不重复的ID？

方案一：利用数据库的自增ID，从1开始，基本可以做到连续递增。Oracle可以用SEQUENCE，MySQL可以用主键的AUTO_INCREMENT，虽然不能保证全局唯一，但每个表唯一，也基本满足需求。

数据库自增ID的缺点是数据在插入前，无法获得ID。数据在插入后，获取的ID虽然是唯一的，但一定要等到事务提交后，ID才算是有效的。有些双向引用的数据，不得不插入后再做一次更新，比较麻烦。

第二种方式是采用一个集中式ID生成器，它可以是Redis，也可以是ZooKeeper，也可以利用数据库的表记录最后分配的ID。

这种方式最大的缺点是复杂性太高，需要严重依赖第三方服务，而且代码配置繁琐。一般来说，越是复杂的方案，越不可靠，并且测试越痛苦。

第三种方式是类似Twitter的Snowflake算法，它给每台机器分配一个唯一标识，然后通过时间戳+标识+自增实现全局唯一ID。这种方式好处在于ID生成算法完全是一个无状态机，无网络调用，高效可靠。缺点是如果唯一标识有重复，会造成ID冲突。

