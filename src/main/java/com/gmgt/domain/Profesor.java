package com.gmgt.domain;

import com.gmgt.dto.ProfesorDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "NOMBRE", nullable = false)
    String nombre;

    @Column(name = "APELLIDO", nullable = false)
    String apellido;

    @Column(name = "PUNTAJE_DOCENTE",nullable = false)
    Integer puntajeDocente;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "PROFESOR_MATERIAS",
            joinColumns = @JoinColumn(name="ID_PROFESOR"),
            inverseJoinColumns = @JoinColumn(name="ID_MATERIA")
    )
    List<Materia> materias = new ArrayList<>();

    public Profesor(String nombre, String apellido, Integer puntajeDocente){
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntajeDocente = puntajeDocente;
    }
    public ProfesorDTO toProfesorDTO() {
        return new ProfesorDTO(this);
    }

    public void agregarMateria(Materia materia){
        this.materias.add(materia);
    }
}
