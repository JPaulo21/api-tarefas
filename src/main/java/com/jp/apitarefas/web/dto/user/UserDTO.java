package com.jp.apitarefas.web.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserDTO(
        @NotBlank(message = "username deve ser preenchido")
        @Size(min = 5, max = 255, message = "Username deve ter entre 5 e 255 caracteres")
        String username,
        @NotBlank(message = "password deve ser preenchido")
        String password,
        @Email(message = "email inválido")
        String email,
        @NotNull(message = "Username deve ser preenchido")
        @Past(message = "birthDate deve está no passado")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate

) {
}
