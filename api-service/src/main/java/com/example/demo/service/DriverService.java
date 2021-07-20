package com.example.demo.service;

import com.example.demo.repository.mysql.DriverRepository;
import com.example.demo.repository.mysql.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public List<Driver> findAll() {
        return driverRepository.findAll().stream().map(driver -> buildDriver(driver)).collect(Collectors.toList());
    }

    public Driver findById(String id) throws Exception {
        return driverRepository.findById(id).map(driver -> buildDriver(driver)).orElseThrow(() -> new Exception("Not Found"));
    }

    public Driver buildDriver(Driver driver) {
        return Driver.builder()
                .id(driver.getId())
                .name(driver.getName())
                .build();
    }

}
