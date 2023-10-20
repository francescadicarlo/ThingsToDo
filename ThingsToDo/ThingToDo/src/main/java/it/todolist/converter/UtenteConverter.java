package it.todolist.converter;

import it.todolist.dto.UtenteDTO;
import it.todolist.model.Utente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UtenteConverter {
    public UtenteDTO toDTO(Utente utente){
//        UtenteDTO utenteDTO=new UtenteDTO(utente.getId(),
//                utente.getNome(),
//                utente.getEta(),
//                utente.getProfessione(),
//                utente.getPassword());
           //     utente.getLista());
        return utente != null ? UtenteDTO.builder()
                .id(utente.getId())
                .eta(utente.getEta())
                .nome(utente.getNome())
                .password(utente.getPassword())
                .professione(utente.getProfessione())
                .build() : null ;
    }

    public Utente toEntity(UtenteDTO utenteDTO){
//       Utente utente=new Utente(utenteDTO.getId(),
//               utenteDTO.getNome(),
//               utenteDTO.getEta(),
//               utenteDTO.getProfessione(),
//               utenteDTO.getPassword(),
//               utenteDTO.getList());
//       return utente;
        return utenteDTO != null ? Utente.builder()
                .id(utenteDTO.getId())
                .eta(utenteDTO.getEta())
                .nome(utenteDTO.getNome())
                .password(utenteDTO.getPassword())
                .professione(utenteDTO.getProfessione())
                .build() : null;
    }
    public List<Utente> toEntityList (List<UtenteDTO> listDTO) {
        List<Utente> list = new ArrayList<Utente>();

        if(listDTO != null) {
            for (UtenteDTO dto:listDTO) {
                Utente entity = toEntity(dto);
                list.add(entity);
            }
        }
        return list;
    }

    public List<UtenteDTO> toDTOList (Iterable<Utente> listEntity) {
        List<UtenteDTO> list = new ArrayList<UtenteDTO>();

        if(listEntity != null) {
            for (Utente entity:listEntity) {
                UtenteDTO dto = toDTO(entity);
                list.add(dto);
            }
        }
        return list;
    }
}
