package com.gmgt.controller;

import com.gmgt.domain.Materia;
import com.gmgt.dto.MateriaDTO;
import com.gmgt.dto.MateriaProfesorDTO;
import com.gmgt.repository.MateriaRepository;
import com.gmgt.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    MateriaService materiaService;

    @GetMapping("/")
    List<MateriaDTO> getMaterias() {
        return materiaService.getMaterias().stream().map(m-> m.fromMateria()).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    MateriaProfesorDTO getMateria(@PathVariable("id") Long id) {
        return materiaService.getMateria(id);
    }
}
