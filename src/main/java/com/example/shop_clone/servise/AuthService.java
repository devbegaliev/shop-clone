package com.example.shop_clone.servise;

import com.example.shop_clone.exception.BadRequest;
import com.example.shop_clone.modul.userDto.AuthDto;
import com.example.shop_clone.modul.userDto.RegisterDto;
import com.example.shop_clone.modul.userEntity.User;
import com.example.shop_clone.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
    public boolean register(RegisterDto dto) {
     Optional optional = userRepository.findByEmailOrContactAndDeletedAtIsNull(dto.getEmail(), dto.getContact());

     if(optional.isPresent()) throw new BadRequest("User already exist");

      User user = new User();
      user.setEmail(dto.getEmail());
      user.setContact(dto.getContact());
      user.setPassword(passwordEncoder.encode(dto.getPasswor()));
      user.setStatus(false);
      user.setCreatedAt(LocalDateTime.now());
      userRepository.save(user);
     return false;
    }

    public AuthDto login(AuthDto dto) {

     return null ;
    }

    public boolean verification(String token) {
        return false;
    }
}
