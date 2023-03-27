package com.example.scoala_generala.repositories;

import com.example.scoala_generala.entities.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfesorRepository extends CrudRepository<Profesor,Integer> {
    Optional<Profesor> findByEmailAddress(String emailAddress);
    Optional<Profesor> findById(int id);
    Optional<Profesor> findByPhoneNumber(String phoneNumber);
}
