package com.dto.demo.service;

import com.dto.demo.dto.EstudianteDto;
import com.dto.demo.dto.ProfesorDto;
import com.dto.demo.entity.Estudiante;
import com.dto.demo.entity.Profesor;
import com.dto.demo.repository.ProfesorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public ProfesorDto save(Profesor profesor){
        Profesor p2 = profesorRepository.save(profesor);
        if(p2.getEstudianteList() == null){
            p2.setEstudianteList(new ArrayList<>());
        }else if(!p2.getEstudianteList().isEmpty()){
            for (Estudiante estudiante: p2.getEstudianteList()) {
                profesorRepository.insertarRelacion(estudiante.getId(), profesor.getId());
            }
        }

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
        return modelMapper.map(profesorList, new TypeToken<List<ProfesorDto>>(){}.getType());
    }
}
