package com.jp.apitarefas.web.controller;

import com.jp.apitarefas.config.security.JWT.TokenDTO;
import com.jp.apitarefas.config.security.JWT.TokenService;
import com.jp.apitarefas.entity.User;
import com.jp.apitarefas.web.dto.login.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        try{
            var authToken = new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password());
            Authentication auth = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(auth);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            TokenDTO token = new TokenDTO(tokenService.generateToken(user));
            return ResponseEntity.ok(token);
        }catch(AuthenticationException e){
            log.warn("Erro de autenticação: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
