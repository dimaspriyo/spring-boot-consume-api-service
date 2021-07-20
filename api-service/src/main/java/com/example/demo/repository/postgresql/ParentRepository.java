package com.example.demo.repository.postgresql;

import com.example.demo.repository.postgresql.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, String> {

}
