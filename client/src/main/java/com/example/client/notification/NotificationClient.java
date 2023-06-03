package com.example.client.notification;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification",
        url = "http://notification:8083"
)
public interface NotificationClient {

    @PostMapping("api/v1/notifications")
    public ResponseEntity<Void> sendNotification(@RequestBody NotificationRequest notificationRequest);
}
