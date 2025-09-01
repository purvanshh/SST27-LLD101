package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        if (!PricingRules.isValidEmail(builder.customerEmail)) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (!PricingRules.isValidDiscount(builder.discountPercent)) {
            throw new IllegalArgumentException("Invalid discount");
        }
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
        // Defensive copy
        this.lines = builder.lines == null ? new ArrayList<>() : List.copyOf(builder.lines);
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return List.copyOf(lines); } // defensive copy
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    public static class Builder {
        private String id;
        private String customerEmail;
        private List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }
        public Builder addLine(OrderLine line) {
            this.lines.add(line);
            return this;
        }
        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }
        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }
        public Order build() {
            return new Order(this);
        }
    }
}
