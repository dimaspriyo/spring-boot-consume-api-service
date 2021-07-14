package com.example.demo.controller;

import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.entity.Account;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.LoginResponse;
import com.example.demo.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {

    final AccountRepository accountRepository;

    final PasswordEncoder encoder;

    public AccountController(AccountRepository accountRepository, PasswordEncoder encoder) {
        this.accountRepository = accountRepository;
        this.encoder = encoder;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Account account) {
        accountRepository.save(account);
        return new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
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

        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) throws Exception {

        Account existingAccount = accountRepository.findByUsername(request.getUsername()).orElseThrow(() -> new Exception("Account Not Found"));
        if (encoder.matches(request.getPassword(), existingAccount.getPassword())) {
            return new ResponseEntity(LoginResponse.builder().token(JWTUtil.generateToken(request.getUsername())).build(), HttpStatus.OK);
        } else {
            throw new Exception("Login Invalid");
        }
    }


}
