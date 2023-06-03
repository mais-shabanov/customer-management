package com.example.notification.rabbitmq;

import com.example.client.notification.NotificationRequest;
import com.example.notification.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private final NotificationService notificationService;
    private final Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        logger.info("Consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
