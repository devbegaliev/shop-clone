package com.example.shop_clone.modul;

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
    @OneToOne
    @JoinColumn(name = "image_id",insertable = false,updatable = false)
    private Image imageid;

    private String status;
    private

}
