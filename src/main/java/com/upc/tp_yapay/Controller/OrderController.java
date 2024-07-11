package com.upc.tp_yapay.Controller;

import com.upc.tp_yapay.DTO.OrderRequestDTO;
import com.upc.tp_yapay.DTO.OrderResponseDTO;
import com.upc.tp_yapay.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

   /* @PostMapping("/create")
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        Long orderId = orderService.createOrder(orderRequestDTO);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @PostMapping("/{orderId}/finalize")
    public ResponseEntity<OrderResponseDTO> finalizeOrder(@PathVariable Long orderId) {
        OrderResponseDTO orderResponseDTO = orderService.finalizeOrder(orderId);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }*/

    // Endpoint para crear una nueva orden con varios productos
    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        try {
            Long orderId = orderService.createOrder(orderRequestDTO);
            // Una vez que la orden se crea, inmediatamente se finaliza para obtener el resumen
            OrderResponseDTO orderResponseDTO = orderService.finalizeOrder(orderId);
            return new ResponseEntity<>(orderResponseDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Manejo de errores si el cliente o el tipo de pago no se encuentran, o si algún producto no existe
            return new ResponseEntity<>(new OrderResponseDTO(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para obtener los detalles de una orden ya creada y finalizada
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrderDetails(@PathVariable Long orderId) {
        try {
            OrderResponseDTO orderResponseDTO = orderService.finalizeOrder(orderId);
            return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Si no se encuentra la orden
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
