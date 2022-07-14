package com.gmgt.service;

import com.gmgt.domain.Materia;
import com.gmgt.dto.*;
import com.gmgt.exception.NotFoundException;
import com.gmgt.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriaService {
    @Autowired
    MateriaRepository materiaRepository;

    @Transactional(readOnly = true)
    public List<Materia> getMaterias() {
        return materiaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MateriaProfesorDTO getMateria(Long id) {

        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Materia no encontrada."));

        List<RowMateriaProfesorDTO> rowMateriaProfesorDTO = materiaRepository.getMateriaConProfesorById(id);

        List<ProfesorSinMateriaDTO> profesoresSinMateriaDTO =
                rowMateriaProfesorDTO.stream()
                        .map(
                                r -> new ProfesorSinMateriaDTO(r)
                        ).collect(Collectors.toList());

        return new MateriaProfesorDTO(materia.getId(), materia.getCodigo(), materia.getNombre(), materia.getAnio(), profesoresSinMateriaDTO);

    }
}
