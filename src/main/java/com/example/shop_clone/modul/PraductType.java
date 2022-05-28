package com.example.shop_clone.modul;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "praduct_type")
public class PraductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String status;
    private LocalDateTime create_at;
    private LocalDateTime updated_at;
    private LocalDateTime delete_at;


}
