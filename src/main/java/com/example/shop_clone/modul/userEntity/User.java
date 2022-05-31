package com.example.shop_clone.modul.userEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String contact;
    private Boolean status;
    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    @ManyToOne
    @JoinColumn(name = ("user_role"), insertable = false, updatable = false)
    private UserRole userRole;


    @Column(name = "user_role_id")
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = ("address"), insertable = false, updatable = false)
    private Address address;

    @Column(name = "address_id")
    private Integer addressId;


    @OneToOne
    @JoinColumn(name = ("image"), insertable = false, updatable = false)
    private Image image;

    @Column(name = "image_id")
    private Integer imageId;
}
