package com.example.shop_clone.modul.orderDto;

import com.example.shop_clone.modul.userEntity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    @NotNull(message = "not found")
    private Integer id;
    @NotNull(message = "not found")
    private User user;
    @NotNull(message = "not found")
    private LocalDateTime deliverdate;
    @NotNull(message = "not found")
    private String requirment;
    @NotNull(message = "not found")
    private String contact;
    @NotNull(message = "not found")
    private LocalDateTime delevereddate;
    @NotNull(message = "not found")
    private String status;
    @NotNull(message = "not found")
    private Double total_price;
}
