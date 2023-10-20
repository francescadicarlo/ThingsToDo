package com.film.film.service;

import com.film.film.converter.UserConverter;
import com.film.film.dao.UserRepository;
import com.film.film.dto.UserDTO;
import com.film.film.model.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserConverter conv;

    @Autowired
    UserRepository repo;

    public UserDTO read (Long id){
        return conv.toDTO(repo.findById(id).get());
    }
    public UserDTO insert (UserDTO userDTO){
        return conv.toDTO(repo.save(conv.toEntity(userDTO)));

    }
    public UserDTO update (UserDTO userDTO){
        return conv.toDTO(repo.save(conv.toEntity(userDTO)));
    }
    public void delete (UserDTO userDTO){
        repo.delete(conv.toEntity(userDTO));
    }
}
