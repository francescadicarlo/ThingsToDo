package com.film.film.controller;

import com.film.film.dto.AnagraficaDTO;
import com.film.film.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anagrafica")
public class AnagraficaController {
    @Autowired
    AnagraficaService serv;
    @GetMapping("/read{id}")
    public AnagraficaDTO read(@PathVariable Long id){
        return serv.read(id);
    }
    @PostMapping("/insert")
    public AnagraficaDTO insert(@RequestBody AnagraficaDTO anagraficaDTO){
        return serv.insert(anagraficaDTO);
    }
    @PostMapping("/update")
    public AnagraficaDTO update(@RequestBody AnagraficaDTO anagraficaDTO) {
        return serv.update(anagraficaDTO);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody AnagraficaDTO anagraficaDTO){
        serv.delete(anagraficaDTO);
    }
}
