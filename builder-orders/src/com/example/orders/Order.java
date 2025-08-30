package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    // Private constructor - only Builder can create instances

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines = Collections.unmodifiableList(new ArrayList<>(builder.lines)); // defensive copy
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    //getters only - no setters for immutability
    
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; } // returns unmodifiable view
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) {
            sum += l.getQuantity() * l.getUnitPriceCents();
        }
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

   
    public static class Builder {
        // Required fields

        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        
        //optional fields
        private Integer discountPercent = null;
        private boolean expedited = false;
        private String notes = null;

        // Constructor requires mandatory fields

        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            if (line != null) {
                //defensive copy to prevent external mutation
                this.lines.add(new OrderLine(line.getSku(), line.getQuantity(), line.getUnitPriceCents()));
            }
            return this;
        }

        public Builder setDiscountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder setExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

    
        public Order build() {
            // Validate required fields
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("Order ID cannot be null or empty");
            }
            
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email format: " + customerEmail);
            }
            
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one line item");
            }
            
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Discount must be between 0 and 100, got: " + discountPercent);
            }

            return new Order(this);
        }
    }
}
