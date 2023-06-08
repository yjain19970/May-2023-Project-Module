package com.scaler.blogapplication.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final IUsersRepository usersRepo; // Injected the IUserRepo.
    private PasswordEncoder passwordEncoder;

    public UserService(@Autowired IUsersRepository usersRepo,
                       @Autowired PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public Users createUser(String userName, String pwd, String email) {
        //ToDo: Add validations: check if user already exists with that email and userName, throw exception
        String hashedPwd = passwordEncoder.encode(pwd); // using passwordEncoder here
        Users user = Users.builder()
                .userName(userName)
                .password(hashedPwd)
                .email(email)
                .build();
        Users createdUser = usersRepo.save(user);

        return createdUser;
    }

    public List<Users> getAllUsers() {
        //ToDo: handle edge cases and throw exceptions
        return usersRepo.findAll();
    }

    public Users loginUser(String uName, String password){
        var savedUser = usersRepo.findByUserName(uName);
        if(savedUser !=null){
            if(passwordEncoder.matches(password, savedUser.getPassword())){
                return savedUser;
            }
            throw new IllegalArgumentException("Wrong credentials...");
        }
        throw new IllegalArgumentException("User doesn't exist");
    }


}
