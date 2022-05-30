package com.example.shop_clone.modul.ptaductDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PraductTypeDto {

    private Integer id;
    @NotNull(message = "not found")
    private String name;
    @NotNull(message = "not found")
    private String status;

}
