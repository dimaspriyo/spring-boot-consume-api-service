package com.example.demo.service;

import com.example.demo.repository.postgresql.ChildRepository;
import com.example.demo.repository.postgresql.ParentRepository;
import com.example.demo.repository.postgresql.entity.Child;
import com.example.demo.repository.postgresql.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParentService {

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    ChildService childService;

    public List<Parent> findAll(){return parentRepository.findAll().stream().map(parent -> {
        Parent tempParent = buildParent(parent);
        tempParent.setChild(childRepository.findByParent(parent).stream().map(child -> childService.buildChild(child)).collect(Collectors.toList()));
        return tempParent;
    }).collect(Collectors.toList());}

    public Parent findById(String id) throws Exception {return parentRepository.findById(id).map(parent -> buildParent(parent)).orElseThrow(() -> new Exception("Parent Not Found"));}

    public Parent buildParent(Parent parent){
        return Parent.builder()
                .id(parent.getId())
                .name(parent.getName())
                .build();
    }
}

