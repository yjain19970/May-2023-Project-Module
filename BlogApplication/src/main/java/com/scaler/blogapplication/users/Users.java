package com.scaler.blogapplication.users;

import com.scaler.blogapplication.commons.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // this thing helps us to create the builder for this entity
@ToString
public class Users extends BaseEntity {


    String userName;
    String email;
    String password;
    String authToken;
    String bio;
    String imageURL;


}
