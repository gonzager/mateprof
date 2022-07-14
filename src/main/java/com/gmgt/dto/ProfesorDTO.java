package com.gmgt.dto;

import com.gmgt.domain.Materia;
import com.gmgt.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ProfesorDTO extends RepresentationModel<ProfesorDTO> {
    Long id;
    String docente;
    Integer puntaje;
    Set<MateriaDTO> materias = new HashSet<>();

    public ProfesorDTO(Profesor profesor)  {
        this.id = profesor.getId();
        this.docente = profesor.getApellido().toUpperCase().concat(" ").concat(profesor.getNombre().toUpperCase());
        this.puntaje = profesor.getPuntajeDocente();
        this.materias =  profesor.getMaterias().stream().map(Materia::fromMateria).collect(Collectors.toSet());
    }
}
