package it.todolist.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Dettaglio {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;

    private Date scadenza;
    private String descrizione;

    @OneToOne
    @JoinColumn (name="dettaglioDaLista", referencedColumnName= "id")
    private Lista lista;
}
