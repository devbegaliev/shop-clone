package com.example.shop_clone.repositories.user;

import com.example.shop_clone.modul.userEntity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
