package com.gmgt.service;

import com.gmgt.domain.Profesor;
import com.gmgt.dto.ProfesorDTO;
import com.gmgt.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;
    @Transactional(readOnly = true)
    public List<Profesor> getProfesores() {
        return profesorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Profesor> getProfesor(Long id) { return profesorRepository.findById(id);}

    @Transactional
    public Profesor saveProfesor(Profesor profesor) { return profesorRepository.save(profesor);}
}
