package com.example.customerserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash
public class MessageDTO implements Serializable {
    private String nameServer;
    private String mess;
}
