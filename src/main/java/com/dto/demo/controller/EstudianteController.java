package com.dto.demo.controller;

import com.dto.demo.dto.EstudianteDto;
import com.dto.demo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public EstudianteDto save (@RequestBody EstudianteDto estudianteDto){
        return estudianteService.save(estudianteDto);
    }

    @GetMapping("/all")
    public List<EstudianteDto> findAll(){
        return estudianteService.findAll();
    }




}
