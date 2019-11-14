package com.gkd.jedis;

/**
 * @author Weishuo Zhang
 * @date 2019/11/13
 * @description
 */
public class Test {

    //初始时间截 (2017-01-01)
    private static final long INITIAL_TIME_STAMP = 1483200000000L;
    //机器id所占的位数
    private static final long WORKER_ID_BITS = 5L;
    //数据标识id所占的位数
    private static final long DATACENTER_ID_BITS = 5L;
    //支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    //支持的最大数据标识id，结果是31
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);
    //序列在id中占的位数
    private final long SEQUENCE_BITS = 12L;
    //机器ID的偏移量(12)
    private final long WORKERID_OFFSET = SEQUENCE_BITS;
    //数据中心ID的偏移量(12+5)
    private final long DATACENTERID_OFFSET = SEQUENCE_BITS + SEQUENCE_BITS;
    //时间截的偏移量(5+5+12)
    private final long TIMESTAMP_OFFSET = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;
    //生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
    private final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);
    //工作节点ID(0~31)
    private long workerId;
    //数据中心ID(0~31)
    private long datacenterId;
    //毫秒内序列(0~4095)
    private long sequence = 0L;
    //上次生成ID的时间截
    private long lastTimestamp = -1L;

    public static void main(String[] args) {
        System.out.println(~(-1L << 5L));
        System.out.println(~(-1L << 12));

        System.out.println(11 | 17);
    }
}
