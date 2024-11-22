package com.pattern.hexagonal.adapter.out.persistence.h2;

import com.pattern.hexagonal.domain.entity.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface H2OrderRepository extends JpaRepository<OrderCartModel, UUID> {
}
