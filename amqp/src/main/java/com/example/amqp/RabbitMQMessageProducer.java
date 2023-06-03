package com.example.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;
    private final Logger logger = LoggerFactory.getLogger(RabbitMQMessageProducer.class);

    public RabbitMQMessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void publish(Object payload, String exchange, String routingKey) {
        logger.info("Publishing to {} using routingKey {}. Payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        logger.info("Published to {} using routingKey {}. Payload: {}", exchange, routingKey, payload);
    }
}
