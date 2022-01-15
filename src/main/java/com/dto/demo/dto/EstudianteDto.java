package com.dto.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
}

