package com.pattern.hexagonal.adapter.in.web;

import com.pattern.hexagonal.adapter.in.web.dto.OrderDto;
import com.pattern.hexagonal.domain.entity.Order;
import com.pattern.hexagonal.domain.entity.port.in.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/cart")
public class CartOrderController {

    private final CartService cartService;

    public CartOrderController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public List<Order> getAllOrdersFromCart(@PathVariable UUID id) {
        return cartService.getAllOrdersFromCart(id);
    }

    @PostMapping("/{id}")
    public void addOrderToCart(@PathVariable  UUID id, @RequestBody OrderDto order) {
        cartService.addOrderToCart(id, order);
    }

    @DeleteMapping("/{id}")
    public void removeOrderFromCart(@PathVariable UUID id) {
        cartService.removeOrderFromCart(id);
    }


}
