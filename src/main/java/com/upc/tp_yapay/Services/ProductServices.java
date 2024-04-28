package com.upc.tp_yapay.Services;

import com.upc.tp_yapay.Entities.Products;
import com.upc.tp_yapay.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    //CRUD CUSTOMER
    public Products save(Products products){
        return productRepository.save(products);
    }

    public List<Products> list(){
        return productRepository.findAll();
    }
}
