package com.gmgt.controller;

import com.gmgt.domain.Materia;
import com.gmgt.dto.MateriaDTO;
import com.gmgt.dto.MateriaProfesorDTO;
import com.gmgt.repository.MateriaRepository;
import com.gmgt.service.MateriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/materias")
@Slf4j
public class MateriaController {
    @Autowired
    MateriaService materiaService;

    @GetMapping("/")
    Page<MateriaDTO> getMaterias(Pageable pageable) {
        log.debug("Controlador getMaterias()");
        return materiaService.getMaterias( pageable).map(Materia::fromMateria);
    }
    @GetMapping("/{id}")
    MateriaProfesorDTO getMateria(@PathVariable("id") Long id) {
        log.debug("Controlador getMaterias({})", id.toString());
        return materiaService.getMateria(id);
    }
}
