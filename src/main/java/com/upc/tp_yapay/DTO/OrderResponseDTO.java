package com.upc.tp_yapay.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO { //DETALLES FINALES DE LA COMPRA DEL CLIENTE, DONDE SE MUESTRA EL TOTAL PAGADO
    private Long orderId;
    private int totalAmount;
}
