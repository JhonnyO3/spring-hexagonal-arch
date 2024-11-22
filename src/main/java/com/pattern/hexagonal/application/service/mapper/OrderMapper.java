package com.pattern.hexagonal.application.service.mapper;

import com.pattern.hexagonal.adapter.in.web.dto.OrderDto;
import com.pattern.hexagonal.adapter.out.persistence.h2.OrderModel;
import com.pattern.hexagonal.domain.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toOrderDTO(Order order);

    Order toOrder(OrderDto orderDTO);

    OrderModel toOrderModel(OrderDto order);

    OrderDto toOrderDTO(OrderModel orderModel);

    Order toOrder(OrderModel orderModel);
}
