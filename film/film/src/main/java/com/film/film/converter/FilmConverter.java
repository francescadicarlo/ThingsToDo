package com.film.film.converter;

import com.film.film.dto.FilmDTO;
import com.film.film.dto.UserDTO;
import com.film.film.model.Film;
import com.film.film.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FilmConverter implements Converter<Film, FilmDTO>{
    @Override
    public FilmDTO toDTO (Film film){
        return film!=null ? FilmDTO.builder()
                .id(film.getId())
                .commento(film.getCommento())
                .descrizione(film.getDescrizione())
                .titolo(film.getTitolo())
                .build():null;
    }

    @Override
    public Film toEntity(FilmDTO filmDTO) {
        return filmDTO!= null ? Film.builder()
                .commento(filmDTO.getCommento())
                .descrizione(filmDTO.getDescrizione())
                .id(filmDTO.getId())
                .titolo(filmDTO.getTitolo())
                .build() :null;
    }

    @Override
    public List<FilmDTO> toDTOList (List <Film> filmList) {
        if (filmList != null) {
            List<FilmDTO> dtoList=new ArrayList<>();
            for (Film film : filmList) {
                dtoList.add(toDTO(film));
            }
            return dtoList;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Film> toEntityList(List<FilmDTO> dtoList) {
        if (dtoList!=null){
            List<Film> filmList=new ArrayList<>();
            for(FilmDTO dto:dtoList){
                filmList.add(toEntity(dto));
            }
            return filmList;

        }
        else{
            return null;
        }
    }
}
