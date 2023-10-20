package com.film.film.service;

import com.film.film.converter.AnagraficaConverter;
import com.film.film.dao.AnagraficaRepository;
import com.film.film.dto.AnagraficaDTO;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaService {
    @Autowired
    AnagraficaConverter conv;
    @Autowired
    AnagraficaRepository repo;
    public AnagraficaDTO read (Long id){
        return conv.toDTO(repo.findById(id).get());
    }
    public AnagraficaDTO insert (AnagraficaDTO anagraficaDTO){
        return conv.toDTO(repo.save(conv.toEntity(anagraficaDTO)));
    }
    public AnagraficaDTO update (AnagraficaDTO anagraficaDTO) {
        return conv.toDTO(repo.save(conv.toEntity(anagraficaDTO)));
    }
    public void delete (AnagraficaDTO anagraficaDTO){
        repo.delete(repo.toEntity(anagraficaDTO));
    }
}
