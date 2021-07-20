package com.example.demo.repository.postgresql;

import com.example.demo.repository.postgresql.entity.Child;
import com.example.demo.repository.postgresql.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child,String> {

    List<Child> findByParent(Parent parent);

}
