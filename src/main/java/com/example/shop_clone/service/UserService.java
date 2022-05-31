package com.example.shop_clone.service;

import com.example.shop_clone.repositories.UserRepository;

import com.example.shop_clone.exception.BadException;
import com.example.shop_clone.exception.BadRequest;
import com.example.shop_clone.modul.userDto.UserDto;
import com.example.shop_clone.modul.userEntity.User;
import com.example.shop_clone.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {





        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public UserDto create(UserDto dto) {
            Optional<User> optional = userRepository.findByEmailOrContactAndDeletedAtIsNull(dto.getEmail(), dto.getContact());

            if(optional.isPresent()) throw new BadRequest("User already exist");
            User user = new User();
            convertDtoToUser(dto, user);
            userRepository.save(user);
            dto.setId(user.getId());
            return dto;
        }

        public UserDto get(Integer id) {
            User user = check(id);
            UserDto dto = new UserDto();
            convertUserToDto(user, dto);

            return dto;
        }

        public boolean update(Integer id, UserDto dto) {
            return true;
        }

        private void convertUserToDto(User user, UserDto dto) {
            dto.setId(user.getId());
            dto.setContact(user.getContact());
            dto.setAddressId(user.getAddressId());
            dto.setPassword(user.getPassword());
            dto.setEmail(user.getEmail());
            dto.setSurname(user.getSurname());
            dto.setName(user.getName());
        }

        User check(Integer id) {
            Optional<User> optional = userRepository.findById(id);
            if(optional.isEmpty()) throw new BadException("User not found");

            return optional.get();
        }
        private void convertDtoToUser(UserDto dto, User user) {
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setContact(dto.getContact());
            user.setPassword(dto.getPassword());
            user.setUserRoleId(dto.getUserTypeid());
            user.setAddressId(dto.getAddressId());
        }
    }
