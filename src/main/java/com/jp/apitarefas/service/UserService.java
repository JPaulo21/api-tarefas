package com.jp.apitarefas.service;

import com.jp.apitarefas.entity.User;
import com.jp.apitarefas.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(User user){
        user.setUsername(user.getUsername().toUpperCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if(userRepository.findByUsername(user.getUsername()).isPresent())
            throw new RuntimeException("Usuário já cadastrado");

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado")
        );
    }

    public User findById(Integer id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Usuário com id=%s não encontrado", id))
        );
        return user;
    }
}
