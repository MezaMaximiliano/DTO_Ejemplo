package com.dto.demo.service;

import com.dto.demo.dto.EstudianteDto;
import com.dto.demo.dto.ProfesorDto;
import com.dto.demo.entity.Profesor;
import com.dto.demo.repository.ProfesorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public ProfesorDto save(ProfesorDto profesorDto){
        Profesor profesor = modelMapper.map(profesorDto,Profesor.class);
        profesorRepository.save(profesor);
        return modelMapper.map(profesor,ProfesorDto.class);
    }

    @Transactional
    public ProfesorDto findById(Long id){
        Profesor profesor = profesorRepository.findById(id).get();
        return modelMapper.map(profesor,ProfesorDto.class);
    }

    @Transactional
    public List<ProfesorDto> findAll(){
        List<Profesor> profesorList = profesorRepository.findAll();
        List<ProfesorDto> profesorDtos = modelMapper.map(profesorList, new TypeToken<List<EstudianteDto>>(){}.getType());
        return profesorDtos;
    }
}
