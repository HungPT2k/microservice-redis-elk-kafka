package com.example.customerserver.service.ServiceIpml;

import com.example.customerserver.DTO.MessageDTO;
import com.example.redisserver.configRedis.MessageDTO1;
import com.example.redisserver.configRedis.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.pubsub.PubSubOutput;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@ComponentScan( "com.example.redisserver")
@Service
public class ConfirmMessage  implements MessageListener{
    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private  Publisher publisher;
   private static MessageDTO messageDTO ;
   private static MessageDTO1 messageDTO1 ;
   public ConfirmMessage(){
       messageDTO=new MessageDTO();
       messageDTO1=new MessageDTO1();
   }


   public MessageDTO ReceiveMessage(){
        return messageDTO;
   }
    public MessageDTO1 ReplyMessage(String  message){
        messageDTO1.setMessDetail(message);
        messageDTO1.setNameServer(messageDTO.getNameServer());
        publisher.publishBtoA(messageDTO1);
        System.out.println("Reply Ok");
        return messageDTO1;
    }


    @Override
    public void onMessage(Message message, byte[] pattern) {
        // messageDTO=null;
        System.out.println("received message from Product-service");
        try {
            messageDTO = mapper.readValue(message.getBody(), MessageDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Starting receive mess "+ messageDTO.getNameServer()+" "+messageDTO.getMess());



    }
}
