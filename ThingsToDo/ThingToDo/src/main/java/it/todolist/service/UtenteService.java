package it.todolist.service;

import it.todolist.converter.UtenteConverter;
import it.todolist.dto.ListaDTO;
import it.todolist.dto.UtenteDTO;
import it.todolist.model.Lista;
import it.todolist.model.Utente;
import it.todolist.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepo repo;
    @Autowired
    private UtenteConverter converter;

  //  public String ciao() {
  //      return "Ciao";
  //  }
    public UtenteDTO read(long id){
        return converter.toDTO(repo.findById(id).get());
    }
    public UtenteDTO insert(UtenteDTO utenteDTO){
        return converter.toDTO(repo.save(converter.toEntity(utenteDTO)));
    }
    public void deleteById(Long id){
        repo.deleteById(id);
    }
    public UtenteDTO update (UtenteDTO utenteDTO){ return converter.toDTO( repo.save(converter.toEntity(utenteDTO)));
    }
    public UtenteDTO verificaLogin (UtenteDTO utenteDTO){
          //  if(repo.findByNome(utenteDTO.getNome()).getNome()== utenteDTO.getNome()) {}
        if(repo.findByNome(utenteDTO.getNome())!=null){
            return converter.toDTO(repo.findByNome(utenteDTO.getNome()));
        }
        else{
           return null;
        }
        }
    public List<UtenteDTO> utentiMaggiorenni() {
        List<UtenteDTO> list = converter.toDTOList(repo.findAll());
        List<UtenteDTO> filteredlistMaggiorenni = list.stream()
                .filter(u -> u.getEta() >= 18)
                .collect(Collectors.toList());
        return filteredlistMaggiorenni;
    }
    //lista di tutti gli utenti che posseggono almeno una lista
//    public List<UtenteDTO> utentiConLista(){
//        List<UtenteDTO> list= converter.toDTOList(repo.findAll());
//        List<UtenteDTO> filteredlistConLista = list.stream()
//          .filter(utenteDTO -> !utenteDTO.getLista().isEmpty())
//          .collect(Collectors.toList());
//        return filteredlistConLista;
//    }
    public List<UtenteDTO>tuttiMarco(){
        List<UtenteDTO> list= converter.toDTOList(repo.findAll());
        List<UtenteDTO> filteredlist= list.stream()
                .filter(utenteDTO -> utenteDTO.getNome().equals("Marco"))
                .collect(Collectors.toList());
        return filteredlist;
    }
    public List<UtenteDTO>tuttiMarcoNoLavandaio(){
        List<UtenteDTO> list= converter.toDTOList(repo.findAll());
        List<UtenteDTO> filteredlist= list.stream()
                .filter(utenteDTO -> !utenteDTO.getNome().equals("Marco"))
                .filter(utenteDTO -> !utenteDTO.getProfessione().equals("Lavandaio"))
                .collect(Collectors.toList());
        return filteredlist;
    }
}
