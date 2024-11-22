package com.pattern.hexagonal.adapter.out.persistence;

import com.pattern.hexagonal.adapter.out.persistence.h2.H2OrderRepository;
import com.pattern.hexagonal.adapter.out.persistence.h2.OrderCartModel;
import com.pattern.hexagonal.application.service.mapper.CartOrderMapper;
import com.pattern.hexagonal.domain.entity.OrderCart;
import com.pattern.hexagonal.domain.entity.port.out.CartRepository;

import java.util.UUID;

public class OrderCartRepositoryImpl implements CartRepository {

    private final H2OrderRepository mongoDbOrderRepository;

    private final CartOrderMapper cartOrderMapper;

    public OrderCartRepositoryImpl(H2OrderRepository mongoDbOrderRepository, CartOrderMapper cartOrderMapper) {
        this.mongoDbOrderRepository = mongoDbOrderRepository;
        this.cartOrderMapper = cartOrderMapper;
    }

    @Override
    public OrderCart findOrderCartByUUID(UUID id) {
        OrderCartModel orderCartModel = mongoDbOrderRepository.findById(id).orElse(null);

        return cartOrderMapper.toCartOrder(orderCartModel);
    }

    @Override
    public void saveOrderCart(OrderCart orderCart) {
        mongoDbOrderRepository.save(cartOrderMapper.toCartOrderModel(orderCart));
    }
}
