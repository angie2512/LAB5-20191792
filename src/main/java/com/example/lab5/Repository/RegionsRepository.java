package com.example.lab5.Repository;

import com.example.lab5.Entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<Regions, Integer> {
}