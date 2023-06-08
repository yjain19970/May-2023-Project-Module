package com.scaler.blogapplication.users;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserLoginDTO {

    @NonNull
    String userName;
    @NonNull
    String password;
}
