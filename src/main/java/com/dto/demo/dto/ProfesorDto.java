package com.dto.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDto implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String materia;
    @JsonIgnoreProperties(value = "profesorList")
    private List<EstudianteDto> estudianteList = new ArrayList<>();
}
