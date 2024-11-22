package com.pattern.hexagonal.adapter.in.web.dto;

import com.pattern.hexagonal.domain.entity.OrderStatus;

public record OrderDto(String name, int amount, OrderStatus orderStatus) {
}
