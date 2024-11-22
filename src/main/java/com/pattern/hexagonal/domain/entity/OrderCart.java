package com.pattern.hexagonal.domain.entity;

import java.util.List;
import java.util.UUID;

public class OrderCart {
    private UUID id;
    private List<Order> orders;
    private String totalAmount;

    public OrderCart(List<Order> orders) {
        this.id = UUID.randomUUID();
        this.orders = orders;
        this.totalAmount = "0";
    }

    public void addOrderInCart(Order order) {
        this.orders.add(order);
    }

    public void removeOrderFromCart(UUID id) {
        if (findProduct(id) != null) {
            this.orders.remove(findProduct(id));
        }
    }

    private Order findProduct(UUID id) {
        return this.orders.stream().filter(order -> order.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
