package it.todolist.converter;

import it.todolist.dto.DettaglioDTO;
import it.todolist.model.Dettaglio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DettaglioConverter {

    public DettaglioDTO toDTO (Dettaglio dettaglio){
        return dettaglio != null ? DettaglioDTO.builder()
                .id(dettaglio.getId())
                .descrizione(dettaglio.getDescrizione())
                .scadenza(dettaglio.getScadenza())
                .build() : null ;
    }
    public Dettaglio toEntity (DettaglioDTO dettaglioDTO){
        return dettaglioDTO != null ? Dettaglio.builder()
                .id(dettaglioDTO.getId())
                .descrizione(dettaglioDTO.getDescrizione())
                .scadenza(dettaglioDTO.getScadenza())
                .build() : null;
    }


}
