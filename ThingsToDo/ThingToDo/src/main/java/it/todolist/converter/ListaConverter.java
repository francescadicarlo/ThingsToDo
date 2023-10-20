package it.todolist.converter;

import it.todolist.dto.ListaDTO;
import it.todolist.model.Lista;
import it.todolist.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ListaConverter {
    @Autowired
    UtenteService serv;
    @Autowired
    UtenteConverter conv;
    public ListaDTO toDTO (Lista lista){
        return lista != null ? ListaDTO.builder()
                .id(lista.getId())
                .utenteId(lista.getUtente().getId())
                .build() : null ;
    }
    public Lista toEntity (ListaDTO listaDTO){
        return listaDTO != null ? Lista.builder()
                .id(listaDTO.getId())
                .utente(conv.toEntity(serv.read(listaDTO.getUtenteId())))
                .build(): null;
    }
    }


