package com.jwt.demo.controller;

import com.jwt.demo.config.JwtUtil;
import com.jwt.demo.config.request.JwtRequest;
import com.jwt.demo.config.response.JwtResponse;
import com.jwt.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenGenrateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtil jwtUtils;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
        try {

            this.authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));

        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("user not found");

        } catch (BadCredentialsException e) {
            e.printStackTrace();
           // new ResponseEntity(HttpStatus.UNAUTHORIZED);
            throw new BadCredentialsException("Bad Credentials");
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtils.generateToken(userDetails);
        System.out.println("token"+token);

        return  ResponseEntity.ok(new JwtResponse(token));
    }
}
