package com.jp.apitarefas.web.controller;

import com.jp.apitarefas.mapper.UserMapper;
import com.jp.apitarefas.service.UserService;
import com.jp.apitarefas.web.dto.user.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDTO userDTO, UriComponentsBuilder ucb){
        log.info("{}", userDTO);
        var user = userService.createUser(userMapper.toUser(userDTO));
        URI location = ucb
                .path("/api/v1/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
