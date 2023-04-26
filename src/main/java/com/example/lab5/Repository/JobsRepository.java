package com.example.lab5.Repository;

import com.example.lab5.Entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, String> {
}