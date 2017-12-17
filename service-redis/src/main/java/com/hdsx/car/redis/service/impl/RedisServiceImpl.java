package com.hdsx.car.redis.service.impl;


import com.hdsx.car.redis.RedisService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

@Api(value = "API - RedisServiceImpl", description = "redis 服务")
@RestController
@RefreshScope
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JedisCluster jedisCluster;
    @Autowired
    private CacheManager cacheManager;

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key,value);
    }

    @Override
    public String hget(String hkey, String key) {
        return jedisCluster.hget(hkey,key);
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return jedisCluster.hset(hkey,key,value);
    }

    @Override
    public long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public long expire(String key, Integer second) {
        return jedisCluster.expire(key,second);
    }

    @Override
    public long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    @Override
    public long del(String key) {
        return jedisCluster.del(key);
    }

    @Override
    public long hdel(String hkey, String key) {
        return jedisCluster.hdel(hkey,key);
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    @Override
    public Set<String> keys(String hkey) {
        return jedisCluster.hkeys(hkey);
    }

    public long hlen(String hkey){
        return jedisCluster.hlen(hkey);
    }
}
