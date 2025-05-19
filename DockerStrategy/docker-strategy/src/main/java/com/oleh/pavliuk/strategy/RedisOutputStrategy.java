package com.oleh.pavliuk.strategy;

import com.oleh.pavliuk.model.KpiRecord;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisOutputStrategy implements OutputStrategy {
    private final Jedis jedis;
    private final String redisKey = "kpi:records";

    public RedisOutputStrategy() {
        this.jedis = new Jedis("redis", 6379);
    }

    @Override
    public void output(List<KpiRecord> records) {
        for (KpiRecord record : records) {
            jedis.rpush(redisKey, record.toString());
        }
        System.out.println("Kpi data stored in Redis");
        jedis.close();
    }
}
