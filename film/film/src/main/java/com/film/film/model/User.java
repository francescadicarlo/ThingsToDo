package com.film.film.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Anagrafica anagrafica;


    @ManyToMany
    @JoinTable(name="user_film",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name= "film_id"))
            private Set<Film> film = new HashSet<>();

}
