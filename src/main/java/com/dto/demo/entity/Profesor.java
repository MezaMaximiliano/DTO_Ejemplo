package com.dto.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String materia;
}
