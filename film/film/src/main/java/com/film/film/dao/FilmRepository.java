package com.film.film.dao;

import com.film.film.model.Film;
import com.film.film.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional

public interface FilmRepository extends CrudRepository <Film, Long> {
}
