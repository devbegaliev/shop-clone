package com.example.shop_clone.modul.orderDto;

import com.example.shop_clone.modul.orderEntity.Order;
import com.example.shop_clone.modul.praductEntity.Praduct;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDto {
    @NotNull(message = "not found")
    private Integer id;
    @NotNull(message = "not found")
    private Order order_id;
    @NotNull(message = "not found")
    private Praduct praduct_id;
    @NotNull(message = "not found")
    private String status;
}
