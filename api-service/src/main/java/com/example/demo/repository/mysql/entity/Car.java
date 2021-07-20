package com.example.demo.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "car")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "production_date")
    private Date productionDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private List<Driver> driver;

}

