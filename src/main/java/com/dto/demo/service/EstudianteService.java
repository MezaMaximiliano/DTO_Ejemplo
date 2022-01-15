package com.dto.demo.service;

import com.dto.demo.dto.EstudianteDto;
import com.dto.demo.entity.Estudiante;
import com.dto.demo.repository.EstudianteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    ModelMapper modelMapper;

    public EstudianteDto save(EstudianteDto estudianteDto){
        Estudiante entity = modelMapper.map(estudianteDto,Estudiante.class);
        estudianteRepository.save(entity);
        return modelMapper.map(entity,EstudianteDto.class);
    }

    public EstudianteDto findById(Long id){
        Estudiante estudiante = estudianteRepository.findById(id).get();
        return modelMapper.map(estudiante,EstudianteDto.class);
    }

    public List<EstudianteDto> findAll(){
        List<Estudiante> estudianteList = estudianteRepository.findAll();
        List<EstudianteDto> estudianteDtos = modelMapper.map(estudianteList, new TypeToken<List<EstudianteDto>>(){}.getType());
        return estudianteDtos;
    }
}
