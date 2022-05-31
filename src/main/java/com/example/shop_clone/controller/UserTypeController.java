package com.example.shop_clone.controller;


import com.example.shop_clone.modul.userEntity.UserRole;
import com.example.shop_clone.servise.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userstype")
public class UserTypeController {

    private final UserRoleService userRoleService;

    public UserTypeController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserRole userRole) {
        UserRole ans = userRoleService.create(userRole);
        return ResponseEntity.ok(userRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        UserRole ans = userRoleService.get(id);
        return ResponseEntity.ok(ans);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody UserRole userRole) {
        boolean ans = userRoleService.update(id, userRole);
        return ResponseEntity.ok(ans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean ans = userRoleService.delete(id);
        return ResponseEntity.ok(ans);
    }
}
