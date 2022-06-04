package com.example.shop_clone.controller.user;

import com.example.shop_clone.modul.userDto.UserDto;
import com.example.shop_clone.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
   private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserDto dto) {
        UserDto ans = userService.create(dto);
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        UserDto ans = userService.get(id);
        return ResponseEntity.ok(ans);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid UserDto dto) {
        boolean ans = userService.update(id, dto);
        return ResponseEntity.ok(ans);
    }
}
