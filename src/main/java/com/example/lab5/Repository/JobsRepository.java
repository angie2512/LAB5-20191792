package com.example.lab5.Repository;

import com.example.lab5.Entity.Jobs;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobsRepository extends JpaRepository<Jobs, Integer> {

    }

