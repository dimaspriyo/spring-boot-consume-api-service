package com.example.demo.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class Account {

    @Id
    private String id;


    @Column(name = "username",
    unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID().toString();
    }
}
