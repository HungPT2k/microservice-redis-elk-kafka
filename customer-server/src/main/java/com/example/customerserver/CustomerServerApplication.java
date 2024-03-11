package com.example.customerserver;

//import com.example.customerserver.service.ServiceIpml.Receiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServerApplication.class, args);
//        ApplicationContext ctx = SpringApplication.run(CustomerServerApplication.class, args);
//        Receiver receiver = ctx.getBean(Receiver.class);
       // receiver.receiveMessage();
    }

}
