package com.pattern.hexagonal.adapter.in.web.dto;

import java.util.List;

public record OrderCartDto(List<OrderDto> orders, String totalAmount) {
}
