package it.todolist.dto;

import it.todolist.model.Lista;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UtenteDTO {

    private long id;
    private String nome;
    private int eta;
    private String professione;
    private String password;

}

