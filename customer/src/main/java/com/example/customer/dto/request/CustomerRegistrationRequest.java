package com.example.customer.dto.request;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
