package com.example.online_backend.repository;

import com.example.online_backend.repository.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepo extends JpaRepository<Child, Integer> {

}
