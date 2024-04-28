package com.upc.tp_yapay.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailsOrder {         //DETALLES DE TODOS LOS PRODUCTOS COMPRADOS EN UNA FECHA ESPECIFICA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_details_order;
    private int amount;
    private int Subtotal;

   /* @OneToMany
    @JoinColumn(name = "id_product") //EN CADA DETALLE DE ORDEN HAY VARIOS PRODUCTOS (DIFERENTES)
    private Products products;*/


}
