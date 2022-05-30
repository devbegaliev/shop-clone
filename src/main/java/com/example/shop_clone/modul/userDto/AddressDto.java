package com.example.shop_clone.modul.userDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {
    private Integer id;
    private String region;
    @NotBlank(message = "city must have!")
    private String city;
    private String district;
    private String street;
    private Integer home;
}
