package com.example.javahans.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

public class RedisLock {
    private String redisLockKey = "redis_hans_lock";

    protected long internalLockLeaseTime = 30000;

    private long timeout = 999999;

    SetParams params = SetParams.setParams().nx().px(internalLockLeaseTime);
    @Autowired
    JedisPool jedisPool;

    public boolean lock(String id)
    {
        Jedis jedis = jedisPool.getResource();
        Long start = System.currentTimeMillis();
        try {
            for (;;) {
                String lock = jedis.set(redisLockKey, id, params);
                if ("OK".equals(lock)) {
                    return true;
                }
                long longTime = System.currentTimeMillis()- start;
                if (longTime >= timeout) {
                    return false;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            jedis.close();
        }
    }
    public boolean unlock(String id)
    {
        Jedis jedis = jedisPool.getResource();
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                " return redis.call('del', KEYS[1])" +
                "else" +
                " return 0" +
                "end";
        try {
            Object result = jedis.eval(
                    script,
                    Collections.singletonList(redisLockKey),
                    Collections.singletonList(id)
            );
            if ("1".equals(result.toString())) {
                return true;
            }
            return false;
        } finally {
            jedis.close();
        }
    }
}
