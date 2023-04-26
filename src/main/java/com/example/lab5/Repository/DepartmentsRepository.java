package com.example.lab5.Repository;

import com.example.lab5.Entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
}