package com.upc.tp_yapay.Controller;

import com.upc.tp_yapay.DTO.DTOCustomer;
import com.upc.tp_yapay.Entities.Customer;
import com.upc.tp_yapay.Services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerCustomer {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/customer")
    public ResponseEntity<DTOCustomer>save(@RequestBody DTOCustomer dtoCustomer){
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(dtoCustomer, Customer.class);
        customerService.save(customer);
        dtoCustomer=modelMapper.map(customer, DTOCustomer.class);
        return new ResponseEntity<>(dtoCustomer, HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<DTOCustomer>> list() {
        ModelMapper modelMapper = new ModelMapper();
        List<DTOCustomer>list= Arrays.asList(modelMapper.map(customerService.list(), DTOCustomer[].class));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
