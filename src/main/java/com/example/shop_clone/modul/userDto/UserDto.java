package com.example.shop_clone.modul.userDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String contact;
    private boolean status;

    private Integer userTypeid;
    private Integer addressId;
}
