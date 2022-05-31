package com.example.shop_clone.modul.userDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDto {
    private String username;
    private String password;
    private String token;
}
