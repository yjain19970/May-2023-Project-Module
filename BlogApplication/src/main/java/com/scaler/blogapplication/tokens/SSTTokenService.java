package com.scaler.blogapplication.tokens;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("sSTTokenService")
public class SSTTokenService implements TokenService{
    @Override
    public String createAuthToken(String userName) {
        return null;
    }

    @Override
    public String getUserNameFromToken(String token) {
        return null;
    }
}
