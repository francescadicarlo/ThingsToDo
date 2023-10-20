package com.film.film.controller;

import com.film.film.dto.AnagraficaDTO;
import com.film.film.dto.UserDTO;
import com.film.film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService serv;

    @GetMapping("/read{id}")
    public UserDTO read(@PathVariable Long id){return serv.read(id);}

    @PostMapping("/insert")
    public UserDTO insert(UserDTO userDTO){
        return serv.insert(userDTO);
    }

    @PutMapping("/update")
        public UserDTO update(UserDTO userDTO){
           return serv.update(userDTO);
    }
    @DeleteMapping("/delete")
        public void  delete(UserDTO userDTO){
        serv.delete(userDTO);
    }
    @GetMapping("/readSeconda")
    public ResponseEntity<UserDTO> readSeconda(Long id){
        try{
            UserDTO result= serv.read(id);
            return ResponseEntity.ok(result);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping ("/insertSeconda")
    public ResponseEntity<UserDTO> insertSeconda(UserDTO userDTO){
        try{
            UserDTO result=serv.insert(userDTO);
            return ResponseEntity.ok(result);

        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
