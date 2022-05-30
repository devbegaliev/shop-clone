package com.example.shop_clone.controller;

import com.example.shop_clone.modul.userDto.AddressDto;
import com.example.shop_clone.servise.AddressServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressServise addressServise;

    public AddressController(AddressServise addressServise) {
        this.addressServise = addressServise;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AddressDto dto) {
        AddressDto ans = addressServise.create(dto);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        AddressDto ans = addressServise.get(id);
        return ResponseEntity.ok(ans);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid AddressDto dto) {
        boolean ans = addressServise.update(id, dto);
        return ResponseEntity.ok(ans);
    }

}
