package com.example.client.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "fraud",
        url = "http://fraud:8082"
)
public interface FraudClient {

    @GetMapping("api/v1/frauds/{customerId}")
    public ResponseEntity<FraudResponse> isFraudster(@PathVariable("customerId") Integer customerId);
}