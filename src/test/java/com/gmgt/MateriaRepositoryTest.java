package com.gmgt;

import com.gmgt.domain.Materia;
import com.gmgt.domain.Profesor;
import com.gmgt.dto.RowMateriaProfesorDTO;
import com.gmgt.repository.MateriaRepository;
import com.gmgt.repository.ProfesorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest

public class MateriaRepositoryTest {
    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Test()
    void materiaSinProfesor(){
        Materia materia = materiaRepository.save(new Materia("Gemetría", "12-345", 3));

        List<RowMateriaProfesorDTO> rowMateriaProfesorDTO =
                materiaRepository.getMateriaConProfesorById(materia.getId());

        assertTrue(rowMateriaProfesorDTO.isEmpty());

    }

    @Test
    void productoCartesiano(){
        Profesor profesor1 = new Profesor("Gerardo","Gonzalez",99);
        Profesor profesor2 = new Profesor("Javier","Molina",99);
        Materia materia = new Materia("Gemetría 1", "12-345", 3);
        profesor1.agregarMateria(materia);
        profesor2.agregarMateria(materia);
        profesorRepository.save(profesor1);
        profesorRepository.save(profesor2);

        List<RowMateriaProfesorDTO> rowMateriaProfesorDTO =
                materiaRepository.getMateriaConProfesorById(materia.getId());

        assertEquals(2, rowMateriaProfesorDTO.size());

    }
}
