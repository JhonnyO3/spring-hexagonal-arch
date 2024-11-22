package com.pattern.hexagonal.domain.entity.port.out;

import com.pattern.hexagonal.domain.entity.OrderCart;

import java.util.UUID;

public interface CartRepository {

    OrderCart findOrderCartByUUID(UUID id);

    void saveOrderCart(OrderCart orderCart);

}
