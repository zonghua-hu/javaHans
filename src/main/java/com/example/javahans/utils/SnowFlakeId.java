package com.example.javahans.utils;

public class SnowFlakeId {
    /**
     * 开始时间戳
     */
    private final long twepoch = 1420041600000L;
    /**
     * 机器id所占位数
     */
    private final long workId = 5L;
    /**
     * 数据标识id位数
     */
    private final long dataCenterIds = 5L;
    /**
     * 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     */
    private final long maxWorkId = -1L ^ (-1L << workId);
    /**
     * 支持的最大数据标识id，结果是31
     */
    private final long maxDatacenterId = -1L ^ (-1L << dataCenterIds);
    /**
     * 序列id所占的位数
     */
    private final long sequenceBits = 12L;
    /**
     * 机器id向左移12位
     */
    private final long workIdShift = sequenceBits;
    /**
     * 数据表示id左移17
     */
    private final long dataCenterIdShift = sequenceBits + workId;
    /**
     * 时间戳左移11位
     */
    private final long timestampLeftShift = sequenceBits + workId + dataCenterIds;
    /**
     * 生成序列掩码
     */
    private  final long sequenceMask = -1L ^ (-1L << sequenceBits);
    /**
     * 工作机器id
     */
    private long work;
    /**
     * 数据中心id
     */
    private long dataCenterId;
    /**
     * 毫秒内序列
     */
    private long sequence = 0L;
    /**
     * 上次生成id的时间戳
     */
    private long lastTimestamp = -1L;

    /**
     * 构造函数1
     * @param work
     * @param dataCenterId
     */
    public SnowFlakeId(long work, long dataCenterId) {
        if (work > maxWorkId || work < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkId));
        }
        if (dataCenterId > maxDatacenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.work = work;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return
     */
    public synchronized long nextId()
    {
        long timestamp = timeGen();
        timestamp = generateId(timestamp);
        return ((timestamp - twepoch) << timestampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (work << workIdShift)
                | sequence;
    }

    /**
     * 获得下一个ID (string)
     * @return
     */
    public synchronized String generateNextId()
    {
        long timestamp = timeGen();
        timestamp = generateId(timestamp);
        return String.valueOf(((timestamp - twepoch) << timestampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (work << workIdShift)
                | sequence);
    }

    /**
     * @param timestamp
     * @return
     */
    private long generateId(long timestamp)
    {
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        return timestamp;
    }
    /**
     *  阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp
     * @return
     */
    protected long tilNextMillis(long lastTimestamp)
    {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }
    /**
     * 返回以毫秒为单位的当前时间
     * @return
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }
}
