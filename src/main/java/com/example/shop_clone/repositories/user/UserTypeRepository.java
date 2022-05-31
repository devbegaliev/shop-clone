package com.example.shop_clone.repositories.user;

import com.example.shop_clone.modul.userEntity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserTypeRepository extends JpaRepository<UserRole, Integer> {
}
