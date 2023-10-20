package it.todolist.service;

import it.todolist.converter.ListaConverter;
import it.todolist.converter.UtenteConverter;
import it.todolist.dto.ListaDTO;
import it.todolist.dto.UtenteDTO;
import it.todolist.model.Lista;
import it.todolist.model.Utente;
import it.todolist.repository.ListaRepo;
import it.todolist.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaService {
    @Autowired
    ListaRepo listaRepo;
    @Autowired
    UtenteRepo utenteRepo;
    @Autowired
    UtenteConverter utenteConv;
    @Autowired
    ListaConverter listaConv;
   // public List<ListaDTO> utentiConLista(){
    //    List<ListaDTO> list =.repo.findAll();
  //  }
    /*public List<UtenteDTO> utentiConLista(){
        List<Utente> list = (List<Utente>) utenteRepo.findAll();
        List<UtenteDTO> filteredlist = list.stream()
                .filter(u-> u.getId().equals(u.getLista().get())).collect(Collectors.toList())
    } */

}
