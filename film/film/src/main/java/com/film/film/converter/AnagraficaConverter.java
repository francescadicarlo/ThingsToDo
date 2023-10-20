package com.film.film.converter;

import com.film.film.dao.AnagraficaRepository;
import com.film.film.dto.AnagraficaDTO;
import com.film.film.model.Anagrafica;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnagraficaConverter implements Converter<Anagrafica, AnagraficaDTO> {

    @Override
    public AnagraficaDTO toDTO(Anagrafica anagrafica){
        return anagrafica!=null ? AnagraficaDTO.builder()
                .id(anagrafica.getId())
                .eta(anagrafica.getEta())
                .professione(anagrafica.getProfessione())
                .build():null;
    }

    @Override
    public Anagrafica toEntity(AnagraficaDTO anagraficaDTO){
        return anagraficaDTO!=null ? Anagrafica.builder()
                .eta(anagraficaDTO.getEta())
                .id(anagraficaDTO.getId())
                .professione(anagraficaDTO.getProfessione())
                .build() : null;
    }
    @Override
    public List<AnagraficaDTO> toDTOList(List<Anagrafica> anagraficaList){
        if(anagraficaList!= null){
            List<AnagraficaDTO> anagraficaDTOList= anagraficaList.stream()
                    .map(anagrafica -> toDTO(anagrafica))
                    .collect(Collectors.toList());
            return anagraficaDTOList;
        }
        else{return null;}
    }

    @Override
    public List<Anagrafica> toEntityList(List<AnagraficaDTO> anagraficaDTOList){
        if (anagraficaDTOList!=null){
            List<Anagrafica> anagraficaList= anagraficaDTOList.stream()
                    .map(anagraficaDTO -> toEntity(anagraficaDTO))
                    .collect(Collectors.toList());
            return anagraficaList;
        }
        else{return null;}

    }
}
