package com.example.demo.controller.postgresql;

import com.example.demo.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postgresql/child")
public class ChildController {

    @Autowired
    ChildService childService;

    @GetMapping
    public ResponseEntity<Object> getAll(){return new ResponseEntity<>(childService.findAll(), HttpStatus.OK);}

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) throws Exception{return new ResponseEntity<>(childService.findById(id),HttpStatus.OK);}


}
