package it.todolist.controller;

import it.todolist.dto.UtenteDTO;
import it.todolist.service.DettaglioService;
import it.todolist.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")

public class UtenteController {

    @Autowired
    private DettaglioService service;
    @Autowired
    private UtenteService utenteService;

//    public UtenteDTO read (int id){
  //      UtenteDTO utenteDTO = pippo.ciao();
 //   }
    @GetMapping("/read")

    public UtenteDTO read (@RequestParam("id")Long id){
     //   DettaglioService.getSingleton();
        return utenteService.read(id);
    }
    @PostMapping ("/create")
    public UtenteDTO create (@RequestBody UtenteDTO utenteDTO){
        return utenteService.insert(utenteDTO);
    }
    @DeleteMapping("/delete")
    public void delete (@RequestParam Long id){
        utenteService.deleteById(id);
    }

    @PutMapping ("/update")
    public UtenteDTO update (@RequestBody UtenteDTO utenteDTO){
        return utenteService.update(utenteDTO);
    }

    @GetMapping ("/verificaLogin")
    public UtenteDTO verificaLogin (@RequestBody UtenteDTO utenteDTO){return utenteService.verificaLogin(utenteDTO); }

    @GetMapping("/verificaMaggiorenni")
    public List<UtenteDTO> verificaMaggiorenni(){ return utenteService.utentiMaggiorenni();
    }
}
