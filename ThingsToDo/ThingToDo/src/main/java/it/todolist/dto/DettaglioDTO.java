package it.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DettaglioDTO {
    private Long id;
    private Date scadenza;
    private String descrizione;
}
