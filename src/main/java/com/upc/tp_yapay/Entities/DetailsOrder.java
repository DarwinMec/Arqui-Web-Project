package com.upc.tp_yapay.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailsOrder {         //DETALLES DE TODOS LOS PRODUCTOS QUE VA A COMPRAR EL CUSTOMER
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_details_order;
    private int amount;
    private int Subtotal;

    @ManyToOne
    @JoinColumn(name = "id_product") //VARIOS DETALLES DE ORDEN PUEDEN ESTAR ASOCIADOS A LA ENTIDAD PRODUCTO
    private Products products;

    @ManyToOne
    @JoinColumn(name = "id_paymentType") //VARIOS DETALLES DE ORDEN ESTAN ASOCIADOS A LA ENTIDAD PAYMENTTYPE
    private PaymentType paymentType;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
