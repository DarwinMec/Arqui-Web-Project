package com.upc.tp_yapay.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class MyOrders {         //MISORDENES ( Y FECHA DE LAS ORDENES DEL CUSTOMER)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_myorders;
    private Date order_date;

    //RELACIONADO PRODUCOTS

}
