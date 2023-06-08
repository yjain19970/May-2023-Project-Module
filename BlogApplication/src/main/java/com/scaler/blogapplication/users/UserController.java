package com.scaler.blogapplication.users;

import com.scaler.blogapplication.articles.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(  UserService service) {
        this.service = service;
    }

    @GetMapping("")
    ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users = service.getAllUsers();
       List<CreateUserDTO> dtoList =  convertUsersToDTO(users);
        return ResponseEntity.accepted().body(users);
    }

    private List<CreateUserDTO> convertUsersToDTO(List<Users> users) { // Bcrypt encoder
        return null;
        // model mapper
    }


    @PostMapping("/login")
    ResponseEntity<Users> loginUser(@RequestBody UserLoginDTO dto){
           Users u =  service.loginUser(dto.getUserName(), dto.getPassword());
           return ResponseEntity.accepted().body(u);
    }

    @PostMapping("/signup")
    ResponseEntity<Users> signUpUser(@RequestBody CreateUserDTO dto){
        Users u =  service.createUser(dto.getUserName(), dto.getPassword(), dto.getEmail());
        return ResponseEntity.accepted().body(u);
    }


}