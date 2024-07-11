package com.upc.tp_yapay.Controller;

import com.upc.tp_yapay.DTO.DTOProducts;
import com.upc.tp_yapay.Entities.Products;
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

    @GetMapping("/Products/search")
    public ResponseEntity<List<DTOProducts>> search(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String size) {
        ModelMapper modelMapper = new ModelMapper();
        List<DTOProducts> products = Arrays.asList(modelMapper.map(productServices.searchBySizeOrName(size, name), DTOProducts[].class));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/Products/sold")
    public ResponseEntity<List<DTOProducts>> listSoldProducts() {
        ModelMapper modelMapper = new ModelMapper();
        List<DTOProducts> products = Arrays.asList(modelMapper.map(productServices.listSoldProducts(), DTOProducts[].class));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/Products/sold/search")
    public ResponseEntity<List<DTOProducts>> searchSoldProductsByName(@RequestParam String name) {
        ModelMapper modelMapper = new ModelMapper();
        List<DTOProducts> products = Arrays.asList(modelMapper.map(productServices.searchSoldProductsByName(name), DTOProducts[].class));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/Products/byBrand")
    public ResponseEntity<List<DTOProducts>> searchByBrand(@RequestParam String brand) {
        ModelMapper modelMapper = new ModelMapper();
        List<DTOProducts> products = Arrays.asList(modelMapper.map(productServices.searchByBrand(brand), DTOProducts[].class));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
