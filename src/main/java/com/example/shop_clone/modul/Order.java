package com.example.shop_clone.modul;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    todo user join
//    private User user;
    private LocalDateTime deliverdate;
    private String requirment;
    private String contact;
    private String adress;
    private LocalDateTime delevereddate;
    private String status;
    private Double total_price;
    private LocalDateTime create_at;
    private LocalDateTime updated_at;
    private LocalDateTime delete_at;


}
