package com.muatik;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by mustafaatik on 26/01/17.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public RedisConnectionFactory createRedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        return factory;
    }

//    SPRING-DATA-REDIS ALREADY PROVIDES A STRING REDIS TEMPLATE, SO THE FOLLOWING IS NOT NECESSARY
//    @Bean
//    public RedisTemplate<String, String> createRedisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }

    @Bean
    public CacheManager redisCacheManager(RedisTemplate redisTemplate) {
//        redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        return cacheManager;
    }
}
