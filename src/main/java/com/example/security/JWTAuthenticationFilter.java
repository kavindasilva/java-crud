package com.example.security;

import com.auth0.jwt.JWT;
import com.example.user.AppUser;
import com.example.user.AppUserRepository;
import com.example.user.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.example.security.SecurityConstants.EXPIRATION_TIME;
import static com.example.security.SecurityConstants.HEADER_STRING;
import static com.example.security.SecurityConstants.SECRET;
import static com.example.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private AppUser currentAuthenticatedUser = null;
//    @Autowired
//    protected AppUserRepository aur;
    protected UserDetailsServiceImpl aur;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ApplicationContext ctx) {
        this.authenticationManager = authenticationManager;
        this.aur= ctx.getBean(UserDetailsServiceImpl.class);
//        this.appUserRepository = arr;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            AppUser creds = new ObjectMapper()
                    .readValue(req.getInputStream(), AppUser.class);
            this.currentAuthenticatedUser = creds;
            System.out.println("attemptAuthentication..." + req.getInputStream());

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getName(),
                            creds.getPassword(),
                            new ArrayList<>()
//                            new ArrayList<Object>(Arrays.asList(1,2,4,5,6,7))
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        System.out.println("Authenticate "+ auth.getPrincipal() );
//        AppUser x1 = aur.findByName("web2");
        AppUser x1 = this.aur.loadUserData(auth.getName());
        System.out.println("Authenticate2 "+ x1.getId() );

        String token = JWT.create()
                .withSubject(auth.getName())
                .withClaim("AppUrl", "https://github.com/kavindasilva/java-crud")
                .withClaim("email", this.currentAuthenticatedUser.getEmail() )
                .withClaim("UserType", x1.getUser_type().getId() ) // @TODO: null handling
//                .withClaim("UserType", auth.getPrincipal() ) // @TODO: null handling
//                .withClaim("UserType", 2) // @TODO: null handling
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}