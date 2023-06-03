package com.example.customer.service;

import com.example.amqp.RabbitMQMessageProducer;
import com.example.client.fraud.FraudClient;
import com.example.client.fraud.FraudResponse;
import com.example.client.notification.NotificationClient;
import com.example.client.notification.NotificationRequest;
import com.example.customer.dto.request.CustomerRegistrationRequest;
import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public CustomerService(CustomerRepository customerRepository, FraudClient fraudClient, RabbitMQMessageProducer rabbitMQMessageProducer) {
        this.customerRepository = customerRepository;
        this.fraudClient = fraudClient;
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
    }

//    @Bean
//    public RabbitMQMessageProducer rabbitMQMessageProducer() {
//        return rabbitMQMessageProducer;
//    }

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = new Customer(
                request.firstName(),
                request.lastName(),
                request.email()
        );
        customerRepository.saveAndFlush(customer);
        FraudResponse fraudResponse = fraudClient.isFraudster(customer.getId()).getBody();
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                "Hi " + customer.getFirstName()
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
