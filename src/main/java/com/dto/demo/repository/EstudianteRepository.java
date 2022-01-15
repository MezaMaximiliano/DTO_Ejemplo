package com.dto.demo.repository;

import com.dto.demo.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {

    Optional<Estudiante> findById(Long id);
    Optional<Estudiante> findByNombre(String nombre);
    Optional<Estudiante> findByEdad(Integer edad);
    List<Estudiante> findAll();

}
