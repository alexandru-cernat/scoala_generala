package com.example.scoala_generala.repositories;

import com.example.scoala_generala.entities.Clasa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasaRepository extends JpaRepository<Clasa,Integer> {

}
