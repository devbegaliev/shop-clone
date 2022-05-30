package com.example.shop_clone.modul.ptaductDto;

import com.example.shop_clone.modul.praductEntity.PraductType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PraductDto {
    private Integer id;
    @NotBlank(message = ("Not found"))
    private String name;
    @NotBlank(message = ("Not found"))
    private String description;
    @NotBlank(message = ("Not found"))
    private Double price;
    @NotBlank(message = ("Not found"))
    private Integer rate;
    @NotBlank(message = ("Not found"))
    private Boolean visible;
    @NotBlank(message = ("Not found"))
    private PraductType praductType;
    @NotBlank(message = ("Not found"))
    private String status;
}
