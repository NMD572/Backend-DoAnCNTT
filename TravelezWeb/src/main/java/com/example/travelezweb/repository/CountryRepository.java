package com.example.travelezweb.repository;

import com.example.travelezweb.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}