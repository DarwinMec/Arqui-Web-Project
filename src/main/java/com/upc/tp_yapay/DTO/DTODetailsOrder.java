package com.upc.tp_yapay.DTO;

import com.upc.tp_yapay.Entities.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTODetailsOrder {
    private Long id_details_order;
    private int amount;
    private int Subtotal;

}
