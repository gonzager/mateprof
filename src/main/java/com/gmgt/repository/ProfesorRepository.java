package com.gmgt.repository;

import com.gmgt.domain.Profesor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
    @EntityGraph(attributePaths = {"materias"})
    List<Profesor> findAll();

    @EntityGraph(attributePaths = {"materias"})
    Optional<Profesor> findById(Long id);
}
