package com.example.shop_clone.modul;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "praducts")
public class Praduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer rate;
    private Boolean visible;
    @ManyToOne
    @JoinColumn(name = ("praduct_id"),updatable = false,insertable = false)
    private PraductType type;

    @Column(name = "praduct_id")
    private Integer praduct;

    private String status;
    private LocalDateTime create_at;
    private LocalDateTime updated_at;
    private LocalDateTime delete_at;

}
