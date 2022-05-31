package com.example.shop_clone.configuration;

import com.example.shop_clone.modul.userEntity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
//foydalanuvchini securityga boshqarish
public class CustomUserDetail implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private boolean status;
    private List<GrantedAuthority> roleList;

    public CustomUserDetail(User user) {
        this.id = user.getId();
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.roleList = List.of(new SimpleGrantedAuthority((user.getUserRole().getName())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }
}
