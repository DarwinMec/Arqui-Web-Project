package com.upc.tp_yapay.Services;

import com.upc.tp_yapay.DTO.OrderRequestDTO;
import com.upc.tp_yapay.DTO.OrderResponseDTO;
import com.upc.tp_yapay.Entities.Customer;
import com.upc.tp_yapay.Entities.DetailsOrder;
import com.upc.tp_yapay.Entities.PaymentType;
import com.upc.tp_yapay.Entities.Products;
import com.upc.tp_yapay.Repository.CustomerRepository;
import com.upc.tp_yapay.Repository.DetailOrderRepository;
import com.upc.tp_yapay.Repository.PaymentTypeRepository;
import com.upc.tp_yapay.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private DetailOrderRepository detailsOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private ProductRepository productsRepository;

    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Customer customer = customerRepository.findById(orderRequestDTO.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + orderRequestDTO.getCustomerId()));

        PaymentType paymentType = paymentTypeRepository.findById(orderRequestDTO.getPaymentTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de pago no encontrado con ID: " + orderRequestDTO.getPaymentTypeId()));

        DetailsOrder detailsOrder = new DetailsOrder();
        detailsOrder.setCustomer(customer);
        detailsOrder.setPaymentType(paymentType);

        int total = 0;
        for (int i = 0; i < orderRequestDTO.getProductIds().size(); i++) {
            Long productId = orderRequestDTO.getProductIds().get(i);
            int quantity = orderRequestDTO.getQuantities().get(i);
            Products product = productsRepository.findById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productId));

            total += ((product.getPrice_product()) * quantity);

            detailsOrder.setProducts(product);
            detailsOrder.setAmount(quantity);
            detailsOrder.setSubtotal((product.getPrice_product()) * quantity);

            detailsOrderRepository.save(detailsOrder);
        }

        detailsOrder.setSubtotal(total);
        detailsOrderRepository.save(detailsOrder);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderId(detailsOrder.getId_details_order());
        orderResponseDTO.setTotalAmount(total);
        return orderResponseDTO;
    }
}
