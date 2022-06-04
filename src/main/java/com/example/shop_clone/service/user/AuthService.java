package com.example.shop_clone.service.user;

import com.example.shop_clone.configuration.JwtTokenUtil;
import com.example.shop_clone.exception.BadRequest;
import com.example.shop_clone.modul.userDto.AuthDto;
import com.example.shop_clone.modul.userDto.RegisterDto;
import com.example.shop_clone.modul.userEntity.User;
import com.example.shop_clone.modul.userEntity.UserRole;
import com.example.shop_clone.repositories.UserRepository;
import com.example.shop_clone.repositories.user.UserTypeRepository;
import lombok.AllArgsConstructor;
import org.hibernate.usertype.UserType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private MessageService messageService;
    private JwtTokenUtil jwtTokenUtil;
    private UserTypeRepository userTypeRepository;
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
    public String register(RegisterDto dto) {
     Optional optional = userRepository.findByEmailOrContactAndDeletedAtIsNull(dto.getEmail(), dto.getContact());

     if(optional.isPresent()) throw new BadRequest("User already exist");

      User user = new User();
      user.setEmail(dto.getEmail());
      user.setContact(dto.getContact());
      user.setPassword(passwordEncoder.encode(dto.getPassword()));
      user.setStatus(false);
      user.setCreatedAt(LocalDateTime.now());

      UserRole userRole = new UserRole();
      userRole.setName("ROLE_ADMIN");
      userRole.setStatus(true);
      userTypeRepository.save(userRole);
      userRepository.save(user);
      String token = jwtTokenUtil.generateAccessToken(user.getEmail(), user.getId());
      String link = "http://localhost:8080/auth/verification" + token;
      String  content = String.format("Please click %s for verification", link);

      try {
          messageService.send(user.getEmail(), "Isystem shop uz verification", content);
      }catch (Exception e) {
          userRepository.delete(user);
      }
     return "Please got to " + dto.getEmail() + " and verification" ;
    }

    public AuthDto login(AuthDto dto) {
        Optional<User> optional = userRepository.findByEmailAndPasswordAndDeletedAtIsNull(dto.getUsername(), dto.getPassword());
        if(optional.isEmpty()) {
            throw new BadRequest("User not found");
        }

        User user = optional.get();
        String token = jwtTokenUtil.generateAccessToken(user.getEmail(), user.getId());
        dto.setToken(token);
     return dto;
    }

    public boolean verification(String token) {
        return false;
    }
}
