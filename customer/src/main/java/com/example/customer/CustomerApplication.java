package com.example.customer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.customer",
                "com.example.amqp"
        }
)
@EnableDiscoveryClient
@EnableFeignClients(
        basePackages = "com.example.client"
)
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableRabbit
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
