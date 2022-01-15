package com.dto.demo.repository;

import com.dto.demo.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {

    Optional<Profesor> findById(Long id);
    List<Profesor> findAll();

}
