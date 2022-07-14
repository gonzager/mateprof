package com.gmgt.controller;

import com.gmgt.domain.Materia;
import com.gmgt.domain.Profesor;
import com.gmgt.repository.MateriaRepository;
import com.gmgt.repository.ProfesorRepository;
import com.gmgt.service.MateriaService;
import com.gmgt.service.ProfesorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.MessageFormat;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayName("Dado un controller de Materia")

public class MateriaControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    MateriaService materiaService;

    @Autowired
    ProfesorService profesorService;

    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Test
    @DisplayName("No se encuentra una materia")
    void materiaNotFound() throws Exception  {
        mockMvc.perform(MockMvcRequestBuilders.get("/materias/0"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Una materia que no tiene profesores")
    void materiaSinProfesor() throws Exception {
        Materia materiaSinProfesor = materiaRepository.save(new Materia("Algebra", "123456", 1));
        mockMvc.perform(MockMvcRequestBuilders.get(MessageFormat.format("/materias/{0}" , materiaSinProfesor.getId())))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(materiaSinProfesor.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profesores").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.profesores").isEmpty());
    }

    @Test
    @DisplayName("Una materia con Profesores")
    void materiaConProfesores() throws  Exception {
        //Arrange
        Profesor profesor1 = new Profesor("Gerardo","Gonzalez",99);
        Materia materiaConProfesores = new Materia("Gemetría 1", "12-345", 3);
        profesor1.agregarMateria(materiaConProfesores);

        profesorService.saveProfesor(profesor1);

        //Act && Assert
        mockMvc.perform(MockMvcRequestBuilders.get(MessageFormat.format("/materias/{0}" , profesor1.getMaterias().stream().findFirst().get().getId())))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(materiaConProfesores.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profesores").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.profesores").isNotEmpty());
    }
}
