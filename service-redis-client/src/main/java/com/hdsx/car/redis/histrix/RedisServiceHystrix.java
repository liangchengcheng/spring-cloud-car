package com.hdsx.car.redis.histrix;

import com.hdsx.car.redis.RedisService;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RedisServiceHystrix implements RedisService {

    @Override
    public String get(String key) {
        System.out.println("==================================");
        return null;
    }

    @Override
    public String set(String key, String value) {
        return null;
    }

    @Override
    public String hget(String hkey, String key) {
        return null;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return 0;
    }

    @Override
    public long incr(String key) {
        return 0;
    }

    @Override
    public long expire(String key, Integer second) {
        return 0;
    }

    @Override
    public long ttl(String key) {
        return 0;
    }

    @Override
    public long del(String key) {
        return 0;
    }

    @Override
    public long hdel(String hkey, String key) {
        return 0;
    }

    @Override
    public CacheManager getCacheManager() {
        return null;
    }


    @Override
    public Set<String> keys(String hkey) {
        return null;
    }

    public long hlen(String hkey){
        return 0;
    }
}

