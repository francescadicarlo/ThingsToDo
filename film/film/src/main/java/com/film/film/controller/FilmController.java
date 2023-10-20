package com.film.film.controller;

import com.film.film.converter.FilmConverter;
import com.film.film.dto.FilmDTO;
import com.film.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService serv;
    @Autowired
    FilmConverter conv;

    @GetMapping("/read/{id}")
    public FilmDTO read (@PathVariable Long id){
        return serv.read(id);
    }

    @PostMapping("/insert")
    public FilmDTO insert (@RequestBody FilmDTO filmDTO) {return  serv.insert(filmDTO);}

    @PostMapping("/update")
    public FilmDTO update(@RequestBody FilmDTO filmDTO){return serv.update(filmDTO);}

    @DeleteMapping ("/delete")
    public void delete(FilmDTO filmDTO){serv.delete(filmDTO);}
}
