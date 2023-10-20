package com.film.film.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnagraficaDTO {

    private Long id;

    private String professione;
    private int eta;
}
