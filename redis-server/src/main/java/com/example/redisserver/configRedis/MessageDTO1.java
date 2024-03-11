package com.example.redisserver.configRedis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash
public class MessageDTO1 implements Serializable {
    private String nameServer;
    private String messDetail;
    private String method;
    private String http;
    private HashMap<String,String> parameters;
    private Object object;
}
