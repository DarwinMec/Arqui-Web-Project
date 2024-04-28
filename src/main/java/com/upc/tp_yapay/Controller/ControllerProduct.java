package com.upc.tp_yapay.Controller;

import com.upc.tp_yapay.DTO.DTOMicroEmployer;
import com.upc.tp_yapay.DTO.DTOProducts;
import com.upc.tp_yapay.Entities.MicroEmployer;
import com.upc.tp_yapay.Entities.Products;
import com.upc.tp_yapay.Services.MicroEmployerService;
import com.upc.tp_yapay.Services.ProductServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerProduct {

    @Autowired
    private ProductServices productServices;
    @PostMapping("/Products")
    public ResponseEntity<DTOProducts> save(@RequestBody DTOProducts dtoProducts) {
        ModelMapper modelMapper = new ModelMapper();
        Products products = modelMapper.map(dtoProducts, Products.class);
        productServices.save(products);
        dtoProducts=modelMapper.map(products, DTOProducts.class);
        return new ResponseEntity<>(dtoProducts, HttpStatus.OK);
    }
    @GetMapping("/Products")
    public ResponseEntity<List<DTOProducts>> list() {
        ModelMapper modelMapper = new ModelMapper();
        List<DTOProducts>list= Arrays.asList(modelMapper.map(productServices.list(), DTOProducts[].class));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
