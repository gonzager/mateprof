package com.gmgt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ProfesorSinMateriaDTO {
    Long id;
    String nombre;
    String apellido;
    Integer puntajeDocente;

    public ProfesorSinMateriaDTO(RowMateriaProfesorDTO rowMateriaProfesorDTO){
        this.id = rowMateriaProfesorDTO.getId();
        this.nombre = rowMateriaProfesorDTO.getProfesorNombre();
        this.apellido = rowMateriaProfesorDTO.getProfesorApellido();
        this.puntajeDocente = rowMateriaProfesorDTO.getProfesorPuntajeDocente();
    }

}
