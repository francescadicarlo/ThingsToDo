package com.film.film.dao;

import com.film.film.dto.AnagraficaDTO;
import com.film.film.model.Anagrafica;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnagraficaRepository extends CrudRepository<Anagrafica, Long> {
    AnagraficaDTO toDTO(Anagrafica anagrafica);

    Anagrafica toEntity(AnagraficaDTO anagraficaDTO);

    List<AnagraficaDTO> toDTOList(List<Anagrafica> anagraficaList);

    List<Anagrafica> toEntityList(List<AnagraficaDTO> anagraficaDTOList);
}
