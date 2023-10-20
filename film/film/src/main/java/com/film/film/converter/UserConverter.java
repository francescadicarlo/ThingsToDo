package com.film.film.converter;

import com.film.film.dao.UserRepository;
import com.film.film.dto.UserDTO;
import com.film.film.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserConverter implements Converter<User,UserDTO>{

   @Override
   public UserDTO toDTO (User user){
        return user!= null ? UserDTO.builder()
                .id(user.getId())
                .password(user.getPassword())
                .username(user.getUsername())
                .build():null;
    }
    @Override
    public User toEntity(UserDTO userDTO){
        return userDTO!=null ? User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build():null;
    }
    @Override
    public List<UserDTO> toDTOList(List<User> userList) {
        if(userList!=null){
            List<UserDTO> userDTOList=new ArrayList<>();
            for(User user:userList){
                userDTOList.add(toDTO(user));
            }
        return userDTOList;
        }
        else {
            return null;
        }


    }
//    public List<User> toEntityList(List<UserDTO> userDTOList) {
//      if(userDTOList!=null){
//          List<User> userList= new ArrayList<>();
//          for (UserDTO dto: userDTOList){
//              userList.add(toEntity(dto));
//          }
//          return userList;
//      }
//       else{
//            return null;
//        }
//    }
    @Override
    public List<User> toEntityList(List<UserDTO> userDTOList){
       return userDTOList.stream()
               .map(userDTO -> toEntity(userDTO))
//                 .map(this::toEntity)
               .collect(Collectors.toList());

//       if(userDTOList!=null){
//            userDTOList.stream()
//                   .map(userDTO -> toEntity(userDTO))
////                 .map(this::toEntity)
//                   .collect(Collectors.toList());
//       }
//        return userList;
    }


}
