package com.example.shop_clone.modul;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id",updatable = false,insertable = false)
    private Order order_id;

    @ManyToOne
    @JoinColumn(name = "praduct_id",insertable = false,updatable = false)
    private Praduct praduct_id;

    private String status;
    private LocalDateTime create_at;
    private LocalDateTime updated_at;
    private LocalDateTime delete_at;
}


