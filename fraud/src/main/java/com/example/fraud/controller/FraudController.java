package com.example.fraud.controller;

import com.example.fraud.dto.response.FraudResponse;
import com.example.fraud.service.FraudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/frauds")
public class FraudController {

    private final FraudService fraudService;
    private final Logger logger = LoggerFactory.getLogger(FraudController.class);

    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<FraudResponse> isFraudster(@PathVariable("customerId") Integer customerId) {
        logger.info("fraud request for customer {}", customerId);
        return ResponseEntity.ok(fraudService.isFraudulentCustomer(customerId));
    }
}
