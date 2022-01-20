package com.dto.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    @JsonIgnoreProperties(value = "estudianteList")
    private List<ProfesorDto> profesorList = new ArrayList<>();
}

