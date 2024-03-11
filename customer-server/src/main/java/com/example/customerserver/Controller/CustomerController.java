package com.example.customerserver.Controller;

import com.example.customerserver.DTO.MessageDTO;
import com.example.customerserver.model.Customer;
import com.example.customerserver.service.ServiceIpml.ConfirmMessage;
import com.example.customerserver.service.UserRepository;
import com.example.redisserver.configRedis.MessageDTO1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConfirmMessage confirmMessage;
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        return userRepository.findById(id);
    }
    @GetMapping("/receive-message")
     public MessageDTO receiveMessage()   {
        return confirmMessage.ReceiveMessage();
    }
    @GetMapping("/reply-message/{mess}")
    public MessageDTO1 confirmMessage(@PathVariable String mess){
        return confirmMessage.ReplyMessage(mess);
    }
}
