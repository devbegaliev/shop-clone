package com.example.shop_clone.servise;


import com.example.shop_clone.exception.BadException;
import com.example.shop_clone.modul.userEntity.User;
import com.example.shop_clone.modul.userEntity.UserRole;
import com.example.shop_clone.repositories.UserRepository;
import com.example.shop_clone.repositories.user.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleService {
    private final UserTypeRepository userTypeRepository;


    public UserRoleService(UserTypeRepository userRepository) {
        this.userTypeRepository = userRepository;
    }

    public UserRole create(UserRole userRole) {
        userRole.setStatus(true);
        userTypeRepository.save(userRole);
        return userRole;
    }

    public UserRole get(Integer id) {
        return check(id);
    }

    public boolean update(Integer id, UserRole role) {

        UserRole userRole = check(id);
        userRole.setName(role.getName());
        userRole.setStatus(role.getStatus());
        userTypeRepository.save(userRole);
        return true;
    }

    public boolean delete(Integer id) {
        userTypeRepository.delete(check(id));
        return true;
    }

    public UserRole check(Integer id) {
        Optional<UserRole> optional = userTypeRepository.findById(id);
        if(optional.isEmpty()) throw new BadException("userType not found");

        return optional.get();
    }
}
