package com.dto.demo.controller;

import com.dto.demo.dto.EstudianteDto;
import com.dto.demo.entity.Estudiante;
import com.dto.demo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(estudianteService.findById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Msg",e.getMessage())
                    .body("No existe estudiante asociado al ID "+id);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody Estudiante estudiante){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/estudiante/save").toUriString());
        try {
            return ResponseEntity.created(uri).body(estudianteService.save(estudiante));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Msg", e.getMessage())
                    .body("Error al guardar datos de estudiante");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update (@ModelAttribute Estudiante estudiante){
        try {
            return ResponseEntity.ok().body(estudianteService.save(estudiante));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Msg", e.getMessage())
                    .body("Error al actualizar alumno");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<EstudianteDto>> findAll(){
        return ResponseEntity.ok().body(estudianteService.findAll());
    }

    @PutMapping("/addProf")
    public ResponseEntity<?> agregarProfAEstudiante(@RequestParam("idEst") Long idEstudiante, @RequestParam("idProf") Long idProfesor){
        try {
            return ResponseEntity.ok().header("Estado alumno", "Profesor agregado a alumno")
                    .body(estudianteService.agregarProfAEstudiante(idEstudiante,idProfesor));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Error",e.getMessage())
                    .body("El profesor ya se encuentra asignado al alumno.");
        }
    }
}
