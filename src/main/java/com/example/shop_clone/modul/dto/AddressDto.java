package com.example.shop_clone.modul.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddressDto {
    private Integer id;
    private String region;
    @NotBlank(message = "city must have!")
    private String city;
    private String district;
    private String street;
    private Integer home;
}
