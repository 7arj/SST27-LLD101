package com.example.payments;

import java.util.Objects;

public class SafeCashAdapter implements PaymentGateway {
    private SafeCashClient safeCashClient;
    
    public SafeCashAdapter(SafeCashClient safeCashClient) {
        this.safeCashClient = Objects.requireNonNull(safeCashClient, "safeCashClient cannot be null");
    }
    
    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");
        if (amountCents <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        
        
        SafeCashPayment payment = safeCashClient.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}
