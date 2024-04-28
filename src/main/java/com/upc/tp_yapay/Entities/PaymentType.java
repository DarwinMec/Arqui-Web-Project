package com.upc.tp_yapay.Entities;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paymenteType;
    private int cardpayment;
    private Date dateexpiration;
    private String titularcard;
    private int CVVcard;
    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
