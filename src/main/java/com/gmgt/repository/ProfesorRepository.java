package com.gmgt.repository;

import com.gmgt.domain.Profesor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
    @EntityGraph(attributePaths = {"materias"})
    List<Profesor> findAll();
}
