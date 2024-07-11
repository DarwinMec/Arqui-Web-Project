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
public class Customer {         //CLIENTE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_customer;
    private String name_customer;
    private String email_customer;
    private Date birthdate_customer;
    private String phone_customer;
    private String address_customer;


}
