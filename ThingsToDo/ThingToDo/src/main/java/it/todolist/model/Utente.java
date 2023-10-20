package it.todolist.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Utente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String nome;
    private int eta;
    private String professione;
    private String password;

    @OneToMany (mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Lista> lista;
}
