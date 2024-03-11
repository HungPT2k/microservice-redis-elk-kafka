package com.example.redisserver.configRedis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
@CacheConfig
public class RedisConfig {

//    @Value("${redis.product.topic}")
//    private String topic;
//    @Bean
//    public RedisMessageListenerContainer listenerContainer(MessageListenerAdapter listenerAdapter,
//                                                           RedisConnectionFactory connectionFactory) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(listenerAdapter, topicA());
//        container.addMessageListener(listenerAdapter, topicB());
//        return container;
//    }
    @Bean
    ChannelTopic topicA() {
        return new ChannelTopic("Product-server");
    }
    @Bean
    ChannelTopic topicB() {
        return new ChannelTopic("Customer-server");
    }

//    @Bean
//    public MessageListenerAdapter listenerAdapter() {
//    return new MessageListenerAdapter();
//}
//    @Bean
//    public MessageListenerAdapter messageListener() {
//        return new MessageListenerAdapter(new Subscriber());
//    }
//    @Bean
//    MessagePublisher redisPublisher() {
//        return new Publisher(redisTemplate(), topicA());
//    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("127.0.0.1");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("123");
        jedisConnectionFactory.setDatabase(0);
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        return jedisConnectionFactory;
    }
    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        template.setValueSerializer(new Jackson2JsonRedisSerializer(MessageDTO1.class));
        return template;
    }


    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(cacheConfiguration)
                .build();
    }
}
