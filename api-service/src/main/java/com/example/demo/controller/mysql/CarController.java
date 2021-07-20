package com.example.demo.controller.mysql;

import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mysql/car")
@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<Object> getAll(){ return new ResponseEntity<>(carService.findAll(), HttpStatus.OK); }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) throws Exception {return new ResponseEntity<>(carService.findById(id),HttpStatus.OK);}

}
