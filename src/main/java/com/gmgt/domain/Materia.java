package com.gmgt.domain;

import com.gmgt.dto.MateriaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;


import javax.persistence.*;



@Entity
@Data
@NoArgsConstructor

public class Materia {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @Column(name = "NOMBRE", nullable = false)
    String nombre;

    @Column(name = "CODIGO", nullable = false, length = 6)
    String codigo;

    @Column(name ="ANIO", nullable = false)
    Integer anio;

    public Materia(String nombre, String codigo, Integer anio){
        this.nombre = nombre;
        this.codigo = codigo;
        this.anio = anio;
    }
    public MateriaDTO fromMateria() {
        return new MateriaDTO(this);
    }
}
