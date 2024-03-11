package com.example.customerserver.config;

import com.example.customerserver.service.ServiceIpml.ConfirmMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class redisconfig {
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Bean
    RedisMessageListenerContainer container(MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.addMessageListener(messageListenerAdapter, topic());
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }
//    @Bean
//    SimpleRqueueListenerContainerFactory containerFactory(){
//
//    }

    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new ConfirmMessage());
    }
//    @Bean
//    Receiver receiver(){return new Receiver();}


    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("Customer-server");
    }

}
