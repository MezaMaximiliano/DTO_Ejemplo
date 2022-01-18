package com.dto.demo.controller;

import com.dto.demo.dto.ProfesorDto;
import com.dto.demo.entity.Profesor;
import com.dto.demo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping
    public List<ProfesorDto> findAll(){
        return profesorService.findAll();
    }

    @GetMapping("/{id}")
    public ProfesorDto findById(@PathVariable Long id){
        return profesorService.findById(id);
    }

    @PostMapping("/save")
    public ProfesorDto save(@RequestBody Profesor profesor){
        return profesorService.save(profesor);
    }
}
