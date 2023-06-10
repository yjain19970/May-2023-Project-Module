package com.scaler.blogapplication.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthentication implements Authentication {

    private final String token;
    private String userName;

    public UserAuthentication(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // ToDo: Not to be implemented RN.
        return null;
    }

    public void setUser(String userName) {
        this.userName = userName;
    }

    @Override
    public String getCredentials() {
        return token;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public String getPrincipal() { // important one
        return this.userName;
    }

    @Override
    public boolean isAuthenticated() {
        return userName !=null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if(!isAuthenticated()){
            this.userName = null;
        }
    }

    @Override
    public String getName() {
        return null;
    }
}
