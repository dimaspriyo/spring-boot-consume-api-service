package com.example.demo.service;

import com.example.demo.repository.mysql.CarRepository;
import com.example.demo.repository.mysql.DriverRepository;
import com.example.demo.repository.mysql.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    DriverRepository driverRepository;

    public List<Car> findAll() {
        return carRepository.findAll().stream().map(car -> {
                    Car tempCar = buildCar(car);
//                    tempCar.setDriver(car.getDriver().stream().map(driver -> driverService.buildDriver(driver)).collect(Collectors.toList()));
//            tempCar.setDriver(driverRepository.find.fin);
                    return tempCar;
                }
        ).collect(Collectors.toList());
    }

    public Car findById(String id) throws Exception {
        return carRepository.findById(id).map(car -> buildCar(car)).orElseThrow(() -> new Exception("Car Not Found"));
    }

    public Car buildCar(Car car) {
        return Car.builder()
                .id(car.getId())
                .name(car.getName())
                .productionDate(car.getProductionDate()).build();
    }

}
