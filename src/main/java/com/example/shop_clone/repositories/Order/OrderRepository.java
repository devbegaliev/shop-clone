package com.example.shop_clone.repositories.Order;

import com.example.shop_clone.modul.orderEntity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
