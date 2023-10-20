package com.film.film.service;

import com.film.film.converter.FilmConverter;
import com.film.film.dao.FilmRepository;
import com.film.film.dto.FilmDTO;
import com.film.film.dto.UserDTO;
import com.film.film.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
     @Autowired
     FilmRepository repo;
     @Autowired
     FilmConverter conv;

    public FilmDTO read (Long id){
        return conv.toDTO(repo.findById(id).get());
    }
    public FilmDTO insert (FilmDTO filmDTO){
        return conv.toDTO(repo.save(conv.toEntity(filmDTO)));
    }
    public FilmDTO update (FilmDTO filmDTO){
        return conv.toDTO(repo.save(conv.toEntity(filmDTO)));
    }
    public void delete(FilmDTO filmDTO){
        repo.delete(conv.toEntity(filmDTO));
    }
}
