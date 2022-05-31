package com.example.shop_clone.configuration;


import com.example.shop_clone.exception.BadException;
import com.example.shop_clone.modul.userEntity.User;
import com.example.shop_clone.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByEmailAndDeletedAtIsNull(username);

        if(optional.isEmpty()) throw new BadException("User not found");

        User user = optional.get();
        return new CustomUserDetail(user);

    }
}
