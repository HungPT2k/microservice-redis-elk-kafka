package com.example.redisserver.configRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Publisher implements MessagePublisher{
    @Autowired
    private RedisTemplate<?, ?> redisTemplate;
    @Qualifier("topicA")
    @Autowired
    private ChannelTopic topicA;

    @Qualifier("topicB")
    @Autowired
    private ChannelTopic topicB;

//    public Publisher() {
//    }
//
//    public Publisher(
//            RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
//        this.redisTemplate = redisTemplate;
//        this.topic = topic;
//    }

    @Override
    public void publishAtoB(MessageDTO1 messageDTO) {

        redisTemplate.convertAndSend("Product-server", messageDTO);
        System.out.println("Sending message A to B: " );
    }

    @Override
    public void publishBtoA(MessageDTO1 messageDTO) {

        redisTemplate.convertAndSend("Customer-server", messageDTO);
        System.out.println("Sending message B to A: ");
    }


}
