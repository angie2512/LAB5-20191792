package com.example.lab5.Repository;

import com.example.lab5.Entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, String> {
}