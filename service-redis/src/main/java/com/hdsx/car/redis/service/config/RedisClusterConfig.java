package com.hdsx.car.redis.service.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.Assert;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * http://blog.csdn.net/zhe1110/article/details/52993082
 */
@Configuration
@ConditionalOnClass(RedisClusterConfig.class)
@EnableConfigurationProperties(RedisClusterProperty.class)
public class RedisClusterConfig {

    @Resource
    private RedisClusterProperty redisClusterProperty;

    @Bean
    public JedisCluster redisCluster(){
        Set<HostAndPort> nodes = new HashSet<>();
        for (String node:redisClusterProperty.getNodes()){
            String[] parts= StringUtils.split(node,":");
            Assert.state(parts.length == 2, "redis node shoule be defined as 'host:port', not '" + Arrays.toString(parts) + "'");
            nodes.add(new HostAndPort(parts[0], Integer.valueOf(parts[1])));
        }

        return new JedisCluster(nodes);
    }

    @Bean
    public CacheManager cacheManager(JedisCluster jedisCluster) {
        JedisClusterConnection clusterConnection = new JedisClusterConnection(jedisCluster);
        RedisClusterConfiguration configuration = new RedisClusterConfiguration();
        for (RedisClusterNode redisClusterNode : clusterConnection.clusterGetNodes()) {
            configuration.addClusterNode(redisClusterNode);
        }
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(configuration);
        // TODO: 2017/12/16 自己加的
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return new RedisCacheManager(template);
    }
}
