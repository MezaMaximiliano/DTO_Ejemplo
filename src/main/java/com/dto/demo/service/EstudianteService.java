package com.dto.demo.service;

import com.dto.demo.dto.EstudianteDto;
import com.dto.demo.entity.Estudiante;
import com.dto.demo.entity.Profesor;
import com.dto.demo.repository.EstudianteRepository;
import com.dto.demo.repository.ProfesorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    ModelMapper modelMapper;

    public EstudianteDto save(Estudiante estudiante) throws Exception{
        estudianteRepository.save(estudiante);
        return modelMapper.map(estudiante,EstudianteDto.class);
    }

    public EstudianteDto findById(Long id)throws Exception{
        Estudiante estudiante = estudianteRepository.findById(id).get();
        if(estudiante==null){
            return modelMapper.map(estudiante,EstudianteDto.class);
        }else{
            throw new Exception("Alumno no encontrado");
        }

    }

    public List<EstudianteDto> findAll(){
        List<Estudiante> estudianteList = estudianteRepository.findAll();
        List<EstudianteDto> estudianteDtos = modelMapper.map(estudianteList, new TypeToken<List<EstudianteDto>>(){}.getType());
        return estudianteDtos;
    }

    public EstudianteDto agregarProfAEstudiante(Long estudianteId,Long profesorId)  throws Exception{
        Estudiante estudiante = estudianteRepository.findById(estudianteId).get();
        Profesor profesor = profesorRepository.findById(profesorId).get();
        estudiante.getProfesorList().add(profesor);
        estudianteRepository.save(estudiante);
        return modelMapper.map(estudiante,EstudianteDto.class);
    }
}
