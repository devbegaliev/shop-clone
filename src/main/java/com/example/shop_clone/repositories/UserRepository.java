package com.example.shop_clone.repositories;

import com.example.shop_clone.modul.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
