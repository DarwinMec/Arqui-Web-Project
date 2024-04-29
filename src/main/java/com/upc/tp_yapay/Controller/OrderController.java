package com.upc.tp_yapay.Controller;

import com.upc.tp_yapay.DTO.OrderRequestDTO;
import com.upc.tp_yapay.DTO.OrderResponseDTO;
import com.upc.tp_yapay.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
//
   /* @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
    OrderResponseDTO orderResponseDTO = orderService.createOrder(orderRequestDTO);
    return new ResponseEntity<>(orderResponseDTO, HttpStatus.CREATED);
    }*/

    @PostMapping("/create")
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        Long orderId = orderService.createOrder(orderRequestDTO);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @PostMapping("/{orderId}/finalize")
    public ResponseEntity<OrderResponseDTO> finalizeOrder(@PathVariable Long orderId) {
        OrderResponseDTO orderResponseDTO = orderService.finalizeOrder(orderId);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }
}
