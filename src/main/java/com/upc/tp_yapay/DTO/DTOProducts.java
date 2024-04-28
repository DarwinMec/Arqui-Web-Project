package com.upc.tp_yapay.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOProducts {
    private Long id_product;
    private String name_product;
    private String description_product;
    private int price_product;
    private String product_brand;
    private String size_product;
    private int quantity_product;
}
