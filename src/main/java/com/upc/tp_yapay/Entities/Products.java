package com.upc.tp_yapay.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Products {         //PRODUCTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String name_product;
    private String description_product;
    private Integer price_product;
    private String product_brand;
    private String size_product;
    private Integer quantity_product;
 }
