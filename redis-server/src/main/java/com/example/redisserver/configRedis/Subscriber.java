package com.example.redisserver.configRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Subscriber  {
//    public static List<String> messageList = new ArrayList<String>();
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

//    public void onMessage(Message message, byte[] pattern) {
//
//        messageList.add(message.toString());
//        System.out.println("Message received: " + Arrays.toString(message.getChannel()));
//        String confirmMess = "OK";
//    }

//    public List<String> getMessagesByChannel(String channel) {
//        // Lấy danh sách tin nhắn theo channel topic từ Redis
//        List<Object> messages = redisTemplate.opsForList().range(channel, 0, -1);
//
//        // In danh sách tin nhắn
//        assert messages != null;
//        for (Object message : messages) {
//            System.out.println("Tin nhắn trong channel " + channel + ": " + message.toString());
//        }
//
//        return messages.stream().map(Object::toString).collect(Collectors.toList());
//    }
}
