package com.upc.tp_yapay.Services;

import com.upc.tp_yapay.DTO.OrderProductDTO;
import com.upc.tp_yapay.DTO.OrderRequestDTO;
import com.upc.tp_yapay.DTO.OrderResponseDTO;
import com.upc.tp_yapay.Entities.*;
import com.upc.tp_yapay.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {


   /* @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DetailOrderRepository detailsOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private ProductRepository productsRepository;

    public Long createOrder(OrderRequestDTO orderRequestDTO) {
       Customer customer = customerRepository.findById(orderRequestDTO.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + orderRequestDTO.getCustomerId()));

        PaymentType paymentType = paymentTypeRepository.findById(orderRequestDTO.getPaymentTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de pago no encontrado con ID: " + orderRequestDTO.getPaymentTypeId()));

        // Crear una nueva orden
        MyOrders order = new MyOrders();
        order.setCustomer(customer);
        order.setPaymentType(paymentType);
        order.setOrderDate(new Date());

        order = orderRepository.save(order);

        int total = 0;
        for (OrderProductDTO orderProductDTO : orderRequestDTO.getProducts()) {
            Long productId = orderProductDTO.getProductId();
            int quantity = orderProductDTO.getQuantity();
            Products product = productsRepository.findById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productId));

            // Verificar si hay suficiente cantidad disponible del producto
            if (product.getQuantity_product() < quantity) {
                throw new IllegalArgumentException("No hay suficiente cantidad disponible del producto: " + product.getName());
            }

            // Calcular el total
            total += (product.getPrice_product() * quantity);

            // Crear un nuevo detalle de orden
            DetailsOrder detailsOrder = new DetailsOrder();
            detailsOrder.setOrder(order);
            detailsOrder.setProducts(product);
            detailsOrder.setAmount(quantity);
            detailsOrder.setSubtotal(product.getPrice_product() * quantity);

            // Guardar el detalle de orden
            detailsOrderRepository.save(detailsOrder);

            // Actualizar la cantidad disponible del producto
            product.setQuantity_product(product.getQuantity_product() - quantity);
            productsRepository.save(product);
        }

        return order.getId();
    }
    public OrderResponseDTO finalizeOrder(Long orderId) {
        List<DetailsOrder> orderDetails = detailsOrderRepository.findAllByOrderId(orderId);

        int totalAmount = 0;
        for (DetailsOrder orderDetail : orderDetails) {
            totalAmount += orderDetail.getSubtotal();
        }

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderId(orderId);
        orderResponseDTO.setTotalAmount(totalAmount);

        return orderResponseDTO;
    }*/

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DetailOrderRepository detailsOrderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;
    @Autowired
    private ProductRepository productRepository;

    public Long createOrder(OrderRequestDTO orderRequestDTO) {
        Customer customer = customerRepository.findById(orderRequestDTO.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + orderRequestDTO.getCustomerId()));

        PaymentType paymentType = paymentTypeRepository.findById(orderRequestDTO.getPaymentTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de pago no encontrado con ID: " + orderRequestDTO.getPaymentTypeId()));

        MyOrders order = new MyOrders();
        order.setCustomer(customer);
        order.setPaymentType(paymentType);
        order.setOrderDate(new Date());
        order.setDetailsOrders(new ArrayList<>()); // Initialize the detailsOrders list

        int total = 0;
        for (OrderProductDTO orderProductDTO : orderRequestDTO.getProducts()) {
            Products product = productRepository.findById(orderProductDTO.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + orderProductDTO.getProductId()));

            int quantity = orderProductDTO.getQuantity();
            int subtotal = product.getPrice_product() * quantity;
            total += subtotal;

            DetailsOrder detailsOrder = new DetailsOrder();
            detailsOrder.setOrder(order);
            detailsOrder.setProducts(product);
            detailsOrder.setAmount(quantity);
            detailsOrder.setSubtotal(subtotal);

            order.getDetailsOrders().add(detailsOrder); // Now it won't throw NullPointerException

            // Actualizar la cantidad disponible del producto
            product.setQuantity_product(product.getQuantity_product() - quantity);
            productRepository.save(product);
        }

        order = orderRepository.save(order); // Guarda la orden con todos los detalles incluidos
        return order.getId();

    }

    public OrderResponseDTO finalizeOrder(Long orderId) {
        MyOrders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada con ID: " + orderId));

        int totalAmount = order.getDetailsOrders().stream()
                .mapToInt(DetailsOrder::getSubtotal)
                .sum();

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderId(orderId);
        orderResponseDTO.setTotalAmount(totalAmount);

        return orderResponseDTO;
    }
}
