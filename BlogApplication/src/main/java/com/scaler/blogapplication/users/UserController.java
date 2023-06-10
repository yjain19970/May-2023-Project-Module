package com.scaler.blogapplication.users;

import com.scaler.blogapplication.tokens.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final TokenService tokenService;

    public UserController(@Autowired UserService service,
                          @Qualifier("jWTTokenService") TokenService tokenService) {
        this.service = service;
        this.tokenService = tokenService;
    }

    @GetMapping("")
    ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = service.getAllUsers();
        List<CreateUserDTO> dtoList = convertUsersToDTO(users);
        return ResponseEntity.accepted().body(users);
    }

    private List<CreateUserDTO> convertUsersToDTO(List<Users> users) { // Bcrypt encoder
        return null;
        // model mapper
    }


    @PostMapping("/login")
    ResponseEntity<Users> loginUser(@RequestBody UserLoginDTO dto) {
        Users u = service.loginUser(dto.getUserName(), dto.getPassword());
        //ToDo :: do the matching of token here and verify if the user is Authenticated OR Not.
        return ResponseEntity.accepted().body(u);
    }

    @PostMapping("/signup")
    ResponseEntity<Users> signUpUser(@RequestBody CreateUserDTO dto) {
        Users u = service.createUser(dto.getUserName(), dto.getPassword(), dto.getEmail());
        String token = tokenService.createAuthToken(dto.getUserName());
        u.setAuthToken(token);
        return ResponseEntity.accepted().
                body(u);
    }


}