package com.example.demo.controller;

import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Account account) {
        accountRepository.save(account);
        return new ResponseEntity("Saved Successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Account> response = (List<Account>) accountRepository.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) throws Exception {
        Account response = accountRepository.findById(id).orElseThrow(() -> new Exception("Account Not Found"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) throws Exception {
        Account account = accountRepository.findById(id).orElseThrow(() -> new Exception("Account Not Found"));
        accountRepository.delete(account);

        return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
    }


}
