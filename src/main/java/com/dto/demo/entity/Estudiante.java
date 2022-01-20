package com.dto.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonIgnoreProperties(value = "estudianteList")
    private List<Profesor> profesorList;
}
