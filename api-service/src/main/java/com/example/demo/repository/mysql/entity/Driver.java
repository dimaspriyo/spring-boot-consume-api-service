package com.example.demo.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driver")
@Builder
public class Driver {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Car car;

}
