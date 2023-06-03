package com.example.fraud.service;

import com.example.fraud.dto.response.FraudResponse;
import com.example.fraud.entity.Fraud;
import com.example.fraud.repository.FraudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudService {

    private final FraudRepository fraudRepository;

    public FraudService(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }


    public FraudResponse isFraudulentCustomer(Integer customerId) {
        Fraud fraud = new Fraud(
                customerId,
                false,
                LocalDateTime.now()
        );
        fraudRepository.save(fraud);
        return new FraudResponse(false);
    }
}
