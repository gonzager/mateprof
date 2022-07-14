package com.gmgt.dto;

import com.gmgt.domain.Materia;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaDTO  {
    Long id;
    String materia;
    String codigo;
    String descripcion;


    public MateriaDTO(Materia materia) {
        this.id = materia.getId();
        this.materia = materia.getCodigo().toUpperCase().concat("-").concat(materia.getNombre().toUpperCase());
        this.codigo = materia.getCodigo();
        this.descripcion = materia.getNombre();
  }
}
