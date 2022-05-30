package com.example.shop_clone.repositories.Order;

import com.example.shop_clone.modul.orderEntity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDto extends JpaRepository<OrderItem,Integer>{
}
