package com.film.film.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDTO {
    private Long id;

    private String titolo;
    private String descrizione;
    private String commento;
}
