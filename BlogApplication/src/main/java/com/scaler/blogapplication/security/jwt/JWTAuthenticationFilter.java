package com.scaler.blogapplication.security.jwt;

import com.scaler.blogapplication.security.UserAuthentication;
import com.scaler.blogapplication.tokens.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

public class JWTAuthenticationFilter extends AuthenticationFilter {

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,
                                   AuthenticationConverter authenticationConverter) {
        super(authenticationManager, authenticationConverter);
    }

    public JWTAuthenticationFilter(@Qualifier("jWTTokenService") TokenService tokenService) {
        super(new JwtAuthenticationManager(tokenService), new JwtAuthenticationConverter());

        /**
         * Every time authentication succeeds, we want to set the Authentication object in the SecurityContext of Spring
         */
        this.setSuccessHandler((request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });
    }

    static class JwtAuthenticationConverter implements AuthenticationConverter{
        @Override
        public Authentication convert(HttpServletRequest request) {
            if(request.getHeader("Authorization") !=null){
                String token = request.getHeader("Authorization")
                        .replace("Bearer ", "");
                return new UserAuthentication(token);
            }
            return null;
        }
    }

    static class JwtAuthenticationManager implements AuthenticationManager{
        private final TokenService tokenService;

        public JwtAuthenticationManager(@Qualifier("jWTTokenService") TokenService tokenService) {
            this.tokenService = tokenService;
        }

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            if (authentication instanceof UserAuthentication) {
                var userAuthentication = (UserAuthentication) authentication;
                var userName = tokenService.getUserNameFromToken(userAuthentication.getCredentials());


                if(userName !=null){
                    userAuthentication.setUser(userName);
                    return userAuthentication;
                }


            }
            return null;
        }
    }


}
