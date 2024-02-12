package com.jp.apitarefas.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TarefaDTO(
        @NotNull
        @FutureOrPresent
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dateRegister,
        @NotBlank
        @Size(min = 3, max = 255)
        String describe,
        @NotNull
        Integer userId
) {
}
