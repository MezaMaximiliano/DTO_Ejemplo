package com.dto.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @ManyToMany(mappedBy = "profesorList",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonIgnoreProperties(value = "profesorList")
    private List<Estudiante> estudianteList;

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", materia='" + materia + '\'' +
                ", estudianteList=" + estudianteList +
                '}';
    }
}
