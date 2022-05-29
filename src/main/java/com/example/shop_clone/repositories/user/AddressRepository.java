package com.example.shop_clone.repositories.user;

import com.example.shop_clone.modul.userEntity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
