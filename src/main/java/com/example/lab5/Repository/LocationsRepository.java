package com.example.lab5.Repository;

import com.example.lab5.Entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Locations, Integer> {
}