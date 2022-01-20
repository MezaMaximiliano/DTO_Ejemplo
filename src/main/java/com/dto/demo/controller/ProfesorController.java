package com.dto.demo.controller;

import com.dto.demo.dto.ProfesorDto;
import com.dto.demo.entity.Estudiante;
import com.dto.demo.entity.Profesor;
import com.dto.demo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/profesor")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("/all")
    public ResponseEntity<List<ProfesorDto>> findAll(){
        return ResponseEntity.ok().body(profesorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(profesorService.findById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Msg",e.getMessage())
                    .body("Error: No existe profesor asociado al ID "+id);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Profesor profesor){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/profesor/save").toUriString());
        try {
            return ResponseEntity.created(uri).body(profesorService.save(profesor));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Msg",e.getMessage())
                    .body("Error al guardar estudiante");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update (@ModelAttribute Profesor profesor){
        try {
            return ResponseEntity.ok().body(profesorService.save(profesor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Msg", e.getMessage())
                    .body("Error al actualizar profesor");
        }
    }

    @PutMapping("/addEst")
    public ResponseEntity<?> agregarProfAEstudiante(@RequestParam("idEst") Long idEstudiante, @RequestParam("idProf") Long idProfesor){
        try {
            return ResponseEntity.ok().header("Estado profesor", "Estudiante agregado a profesor")
                    .body(profesorService.agregarEstudianteAProf(idEstudiante,idProfesor));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Error",e.getMessage())
                    .body("El estudiante ya se encuentra asignado al profesor.");
        }
    }
}
