package com.dto.demo.repository;

import com.dto.demo.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {

    Optional<Profesor> findById(Long id);
    List<Profesor> findAll();

    @Modifying
    @Query(value = "INSERT INTO estudiante_profesor_list (estudiante_list_id,profesor_list_id) " +
            "VALUES (?1,?2)",nativeQuery = true)
    void insertarRelacion(Long idEstudiante, Long idProfesor);

}
