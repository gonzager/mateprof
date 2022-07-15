package com.gmgt.repository;

import com.gmgt.domain.Materia;

import com.gmgt.dto.RowMateriaProfesorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaRepository extends PagingAndSortingRepository<Materia, Long> {
    Page<Materia> findAll(Pageable pageable);

    @Query(
            "select m.id as id " +
            ", m.codigo as codigo " +
            ", m.nombre as descripcion " +
            ", p.id as profesorId " +
            ", p.nombre as profesorNombre " +
            ", p.apellido as profesorApellido " +
            ", p.puntajeDocente as profesorPuntajeDocente " +
            "from Profesor p inner join p.materias m " +
            "where m.id = :id")
    List<RowMateriaProfesorDTO> getMateriaConProfesorById(Long id);
}
