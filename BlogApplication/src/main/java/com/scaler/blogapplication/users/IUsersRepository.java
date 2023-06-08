package com.scaler.blogapplication.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByBio(String bio);

    Users findByBio(String bio);

    Users findByEmail(String email);

    Users findByUserName(String userName);
}