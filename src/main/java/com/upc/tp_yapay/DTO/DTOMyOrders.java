package com.upc.tp_yapay.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOMyOrders {
    private Long id_myorders;
    private String order_status;
    private Date order_date;

}
