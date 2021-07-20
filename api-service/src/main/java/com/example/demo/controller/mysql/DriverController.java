package com.example.demo.controller.mysql;

import com.example.demo.repository.mysql.entity.Driver;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mysql/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping
    public ResponseEntity<Object> getAll(){return new ResponseEntity<>(driverService.findAll(), HttpStatus.OK);}

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) throws Exception {return new ResponseEntity<>(driverService.findById(id),HttpStatus.OK);}

}
