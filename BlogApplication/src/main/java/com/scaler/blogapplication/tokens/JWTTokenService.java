package com.scaler.blogapplication.tokens;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("jWTTokenService")
public class JWTTokenService implements TokenService{
    private final Algorithm algorithm;
    private final String KEY = "my random blog-api key that should not be shared";
    private final String ISSUER = "blog-api";
    private final long TOKEN_EXPIRATION_TIME_MS = 1000*69*60*24;

    public JWTTokenService() {
        this.algorithm = Algorithm.HMAC256(KEY);
    }

    @Override
    public String createAuthToken(String userName) {
        String token = JWT.create()
                .withIssuer(ISSUER)
                .withSubject(userName)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+TOKEN_EXPIRATION_TIME_MS))
                .sign(algorithm);
        return token;
    }

    @Override
    public String getUserNameFromToken(String token) {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();
        return verifier.verify(token).getSubject();
    }
}
