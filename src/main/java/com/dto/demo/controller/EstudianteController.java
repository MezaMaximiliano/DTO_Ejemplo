package com.dto.demo.controller;

import com.dto.demo.dto.EstudianteDto;
import com.dto.demo.entity.Estudiante;
import com.dto.demo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("{id}")
    public EstudianteDto findById(@PathVariable Long id){
        return estudianteService.findById(id);
    }

    @PostMapping("/save")
    public EstudianteDto save (@RequestBody Estudiante estudiante){
        return estudianteService.save(estudiante);
    }

    @PutMapping("/update")
    public EstudianteDto update (@ModelAttribute Estudiante estudiante){
        return estudianteService.save(estudiante);
    }

    @GetMapping("/all")
    public List<EstudianteDto> findAll(){
        return estudianteService.findAll();
    }

    @PutMapping("/addProf")
    public ResponseEntity<EstudianteDto> agregarProfAEstudiante(@RequestParam("idEst") Long idEstudiante, @RequestParam("idProf") Long idProfesor){
            return ResponseEntity.ok().header("Estado alumno", "Profesor agregado a alumno")
            .body(estudianteService.agregarProfAEstudiante(idEstudiante,idProfesor));
    }




}
