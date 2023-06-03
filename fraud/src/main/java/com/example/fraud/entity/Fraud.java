package com.example.fraud.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Fraud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

    public Fraud() {
    }

    public Fraud(
            Integer customerId,
            boolean isFraudster,
            LocalDateTime createdAt
    ) {
        this.customerId = customerId;
        this.isFraudster = isFraudster;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Boolean getFraudster() {
        return isFraudster;
    }

    public void setFraudster(Boolean fraudster) {
        isFraudster = fraudster;
    }

    public LocalDateTime getLocalDateTime() {
        return createdAt;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.createdAt = localDateTime;
    }
}
