package com.upc.tp_yapay.Controller;

import com.upc.tp_yapay.DTO.DTOCustomer;
import com.upc.tp_yapay.DTO.DTOMicroEmployer;
import com.upc.tp_yapay.Entities.Customer;
import com.upc.tp_yapay.Entities.MicroEmployer;
import com.upc.tp_yapay.Services.CustomerService;
import com.upc.tp_yapay.Services.MicroEmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerMicroEmployer {
    @Autowired
    private MicroEmployerService microEmployerService;
    @PostMapping("/Employer")
    public ResponseEntity<DTOMicroEmployer> save(@RequestBody DTOMicroEmployer dtoMicroEmployer) {
        ModelMapper modelMapper = new ModelMapper();
        MicroEmployer microEmployer = modelMapper.map(dtoMicroEmployer, MicroEmployer.class);
        microEmployerService.save(microEmployer);
        dtoMicroEmployer=modelMapper.map(microEmployer, DTOMicroEmployer.class);
        return new ResponseEntity<>(dtoMicroEmployer, HttpStatus.OK);
    }
    @GetMapping("/Employer")
    public ResponseEntity<List<DTOMicroEmployer>> list() {
        ModelMapper modelMapper = new ModelMapper();
        List<DTOMicroEmployer>list= Arrays.asList(modelMapper.map(microEmployerService.list(), DTOMicroEmployer[].class));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
