package com.pattern.hexagonal.adapter.out.persistence.h2;

import com.pattern.hexagonal.domain.entity.OrderStatus;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Table(name = "order")
public class OrderModel {
    private UUID id;
    private String name;
    private int amount;
    private OrderStatus status;

    public OrderModel(String name, int amount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.amount = amount;
        this.status = OrderStatus.PENDING;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public void approve() {
        this.status = OrderStatus.APPROVED;
    }

    public void reject() {
        this.status = OrderStatus.REJECTED;
    }

    public void applyDiscount(int discountPercentage) {
        this.amount = this.amount - (this.amount * discountPercentage / 100);
    }

    public UUID getId() {
        return id;
    }
}
