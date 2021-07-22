package com.likelion.hackaton.repository;

import com.likelion.hackaton.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long> {
    Optional<City> findByName(String name);
}
