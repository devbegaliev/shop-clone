package com.example.shop_clone.repositories;

import com.example.shop_clone.modul.userEntity.User;
import com.example.shop_clone.modul.userEntity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndDeletedAtIsNull(String email);
    Optional<User> findByEmailOrContactAndDeletedAtIsNull(String email, String contact);
}
