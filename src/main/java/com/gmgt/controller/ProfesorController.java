package com.gmgt.controller;

import com.gmgt.dto.ProfesorDTO;
import com.gmgt.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping("profesor")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping ("/")
    public List<ProfesorDTO> gerProfesores() {
        return profesorService.getProfesores().stream()
                .map( p->p.toProfesorDTO()
                        .add(
                                linkTo(methodOn(ProfesorController.class)
                                .getProfesor(p.getId())).withSelfRel()
                        )
        ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProfesorDTO getProfesor(@PathVariable("id") Long id) {
        return profesorService.getProfesor(id)
                .orElseThrow(()-> new RuntimeException())
                .toProfesorDTO()
                .add(linkTo(methodOn(ProfesorController.class)
                        .getProfesor(id))
                        .withSelfRel()
                );
    }
}
