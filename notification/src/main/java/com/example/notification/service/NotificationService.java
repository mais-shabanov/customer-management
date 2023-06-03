package com.example.notification.service;

import com.example.client.notification.NotificationRequest;
import com.example.notification.entity.Notification;
import com.example.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public void send(NotificationRequest notificationRequest) {
        Notification notification = new Notification(
                notificationRequest.toCustomerId(),
                notificationRequest.toCustomerEmail(),
                "Mais",
                notificationRequest.message(),
                LocalDateTime.now()
        );
        notificationRepository.save(notification);
    }
}
