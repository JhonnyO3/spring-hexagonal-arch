package com.pattern.hexagonal.application.service;

import com.pattern.hexagonal.adapter.in.web.dto.OrderDto;
import com.pattern.hexagonal.application.service.mapper.CartOrderMapper;
import com.pattern.hexagonal.application.service.mapper.OrderMapper;
import com.pattern.hexagonal.domain.entity.Order;
import com.pattern.hexagonal.domain.entity.OrderCart;
import com.pattern.hexagonal.domain.entity.port.in.CartService;
import com.pattern.hexagonal.domain.entity.port.out.CartRepository;

import java.util.List;
import java.util.UUID;

public class OrderCartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final OrderMapper orderMapper;

    public OrderCartServiceImpl(CartRepository cartRepository, CartOrderMapper cartOrderMapper, OrderMapper orderMapper) {
        this.cartRepository = cartRepository;

        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> getAllOrdersFromCart(UUID id) {

        OrderCart orderCartByUUID = cartRepository.findOrderCartByUUID(id);
        if (orderCartByUUID != null) {
            return orderCartByUUID.getOrders();
        }
        return List.of();
    }

    @Override
    public void addOrderToCart(UUID id, OrderDto order) {
        OrderCart orderCartByUUID = cartRepository.findOrderCartByUUID(id);
        if (orderCartByUUID != null) {
            orderCartByUUID.addOrderInCart(orderMapper.toOrder(order));
            cartRepository.saveOrderCart(orderCartByUUID);
        }
    }

    @Override
    public void removeOrderFromCart(UUID id) {
        OrderCart orderCartByUUID = cartRepository.findOrderCartByUUID(id);
        if (orderCartByUUID != null) {
            orderCartByUUID.removeOrderFromCart(id);
            cartRepository.saveOrderCart(orderCartByUUID);
        }

    }
}
