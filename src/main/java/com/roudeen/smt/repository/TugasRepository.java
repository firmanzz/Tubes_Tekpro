package com.roudeen.smt.repository;

import com.roudeen.smt.model.Tugas;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TugasRepository extends MongoRepository<Tugas, String> {
    @Query("{'name': ?0}")
    Optional<Tugas> findByName(String name);
}
