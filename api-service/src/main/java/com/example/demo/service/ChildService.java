package com.example.demo.service;

import com.example.demo.repository.postgresql.ChildRepository;
import com.example.demo.repository.postgresql.entity.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildService {

    @Autowired
    ChildRepository childRepository;

    public List<Child> findAll() { return childRepository.findAll().stream().map(child -> buildChild(child)).collect(Collectors.toList()); }

    public Child findById(String id) throws Exception {return childRepository.findById(id).map(child -> buildChild(child)).orElseThrow(() -> new Exception("Child Not Found"));}

    public Child buildChild(Child child){
        return Child.builder()
                .id(child.getId())
                .name(child.getName())
                .birthDate(child.getBirthDate()).build();
    }
}
