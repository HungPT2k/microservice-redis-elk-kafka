package com.example.redisserver.configRedis;

public interface MessagePublisher {
    void publishAtoB(MessageDTO1 object);
    void publishBtoA(MessageDTO1 object);
}
