package com.pattern.hexagonal.application.service.mapper;

import com.pattern.hexagonal.adapter.in.web.dto.OrderCartDto;
import com.pattern.hexagonal.adapter.in.web.dto.OrderDto;
import com.pattern.hexagonal.adapter.out.persistence.h2.OrderCartModel;
import com.pattern.hexagonal.adapter.out.persistence.h2.OrderModel;
import com.pattern.hexagonal.domain.entity.Order;
import com.pattern.hexagonal.domain.entity.OrderCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartOrderMapper {

    OrderCartModel toCartOrderModel(OrderCart orderCartDTO);

    OrderCart toCartOrder(OrderCartModel orderCartModel);
}
