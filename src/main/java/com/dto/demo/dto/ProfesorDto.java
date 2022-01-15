package com.dto.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String materia;
}
