package com.pattern.hexagonal.domain.entity.port.in;

import com.pattern.hexagonal.adapter.in.web.dto.OrderDto;
import com.pattern.hexagonal.domain.entity.Order;

import java.util.List;
import java.util.UUID;

public interface CartService {

    List<Order> getAllOrdersFromCart(UUID id);

    void addOrderToCart(UUID id, OrderDto order);

    void removeOrderFromCart(UUID id);
}
