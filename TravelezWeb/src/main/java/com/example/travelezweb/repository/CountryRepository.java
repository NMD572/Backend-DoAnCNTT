package com.example.travelezweb.repository;

import com.example.travelezweb.model.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Page<Country> findAll(Pageable pageable);
}