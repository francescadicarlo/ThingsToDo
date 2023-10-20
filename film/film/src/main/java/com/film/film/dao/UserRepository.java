package com.film.film.dao;

import com.film.film.converter.UserConverter;
import com.film.film.dto.UserDTO;
import com.film.film.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@Transactional

public interface UserRepository extends CrudRepository<User, Long> {

}
