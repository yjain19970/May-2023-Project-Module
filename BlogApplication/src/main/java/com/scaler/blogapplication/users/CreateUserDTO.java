package com.scaler.blogapplication.users;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserDTO {
    String userName;
    @NonNull
    String email;
    @NonNull
    String password;
}
