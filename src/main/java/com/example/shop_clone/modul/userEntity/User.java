package com.example.shop_clone.modul.userEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private String status;


    @ManyToOne
    @JoinColumn(name = ("user_type_role"))


}
