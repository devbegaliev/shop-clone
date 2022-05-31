package com.example.shop_clone.service.user;


import com.example.shop_clone.exception.BadException;
import com.example.shop_clone.modul.userDto.AddressDto;
import com.example.shop_clone.modul.userEntity.Address;
import com.example.shop_clone.repositories.user.AddressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AddressServise {
    private final AddressRepository addressRepository;


    public AddressServise(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public AddressDto create(AddressDto dto) {
        Address address = new Address();
        convertDtoToAddress(dto, address);
        address.setCreateAt(LocalDateTime.now());
        addressRepository.save(address);
        dto.setId(address.getAddressId());
        return dto;
    }




    public AddressDto get(Integer id) {
       Address address = check(id);
       AddressDto dto = new AddressDto();

       convertAddressToDto(address, dto);
       return dto;
    }

    public Address check(Integer id) {
        Optional<Address> optional = addressRepository.findById(id);

        if (optional.isEmpty()) throw new BadException("address not found");

       return optional.get();
    }

    public void convertDtoToAddress(AddressDto dto, Address address) {
        address.setCity(dto.getCity());
        address.setDistrict(dto.getDistrict());
        address.setRegion(dto.getRegion());
        address.setHome(dto.getHome());
    }

    public void convertAddressToDto(Address address, AddressDto dto) {
        dto.setCity(address.getCity());
        dto.setDistrict(address.getDistrict());
        dto.setStreet(address.getStreet());
        dto.setHome(address.getHome());
        dto.setId(address.getAddressId());
    }

    public boolean update(Integer id, AddressDto dto) {
        Address address = check(id);
        convertDtoToAddress(dto, address);
        address.setUpdateAt(LocalDateTime.now());
        addressRepository.save(address);
        return true;
    }
}

