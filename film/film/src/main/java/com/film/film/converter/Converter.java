package com.film.film.converter;

import java.util.List;
import java.util.Optional;

public interface Converter<Entity,DTO> {
    public DTO toDTO (Entity entity);
    public Entity toEntity(DTO dto);
    public List<DTO> toDTOList (List<Entity> entity);
    public List<Entity> toEntityList (List<DTO> dto);
}
