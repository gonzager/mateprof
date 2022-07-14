package com.gmgt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public
class MateriaProfesorDTO {
    Long id;
    String codigo;
    String descripcion;
    Integer anio;
    List<ProfesorSinMateriaDTO> profesores;
}
