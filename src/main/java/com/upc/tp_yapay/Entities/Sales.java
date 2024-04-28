package com.upc.tp_yapay.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Sales { //VENTAS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sale;
    private int numer_order;
}
