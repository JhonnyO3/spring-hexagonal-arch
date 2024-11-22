package com.pattern.hexagonal.adapter.out.persistence.h2;

import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Table(name = "orderCart")
public class OrderCartModel {
    private UUID id;
    private List<OrderModel> orderModels;
    private String totalAmount;

    public OrderCartModel(List<OrderModel> orderModels) {
        this.id = UUID.randomUUID();
        this.orderModels = orderModels;
        this.totalAmount = "0";
    }

    public void addOrderInCart(OrderModel orderModel) {
        this.orderModels.add(orderModel);
    }

    public void removeOrderFromCart(UUID id) {
        if (findProduct(id) != null) {
            this.orderModels.remove(findProduct(id));
        }
    }

    private OrderModel findProduct(UUID id) {
        return this.orderModels.stream().filter(orderModel -> orderModel.getId().equals(id)).findFirst().orElse(null);
    }

    public List<OrderModel> getOrders() {
        return orderModels;
    }
}
