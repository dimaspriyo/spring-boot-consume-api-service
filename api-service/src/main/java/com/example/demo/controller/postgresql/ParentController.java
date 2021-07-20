package com.example.demo.controller.postgresql;

import com.example.demo.repository.postgresql.entity.Parent;
import com.example.demo.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping("postgresql/parent")
public class ParentController {

    @Autowired
    ParentService parentService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<Parent> response = parentService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);}

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) throws Exception {return new ResponseEntity<>(parentService.findById(id),HttpStatus.OK);}


}
