package com.example.payments;

import java.util.Objects;

public class FastPayAdapter implements PaymentGateway {
    private FastPayClient fastPayClient;
    
    public FastPayAdapter(FastPayClient fastPayClient) {
        this.fastPayClient = Objects.requireNonNull(fastPayClient, "fastPayClient cannot be null");
    }
    
    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");
        if (amountCents <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        
        // Delegate to FastPayClient
        return fastPayClient.payNow(customerId, amountCents);
    }
}