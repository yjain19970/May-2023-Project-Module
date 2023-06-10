package com.scaler.blogapplication.tokens;

import org.springframework.stereotype.Service;


public interface TokenService {
    String createAuthToken(String userName);

    String getUserNameFromToken(String token);
}
