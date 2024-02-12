package com.jp.apitarefas.web.controller;

import com.jp.apitarefas.entity.Tarefa;
import com.jp.apitarefas.mapper.TarefaMapper;
import com.jp.apitarefas.service.TarefaService;
import com.jp.apitarefas.web.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaMapper tarefaMapper;
    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity createTarefa(@RequestBody TarefaDTO tarefaDTO, UriComponentsBuilder ucb){
        Tarefa tarefa = tarefaService.createTarefa(tarefaMapper.toTarefa(tarefaDTO));
        URI location = ucb
                .path("/api/v1/tarefas/{id}/user/{userId}")
                .buildAndExpand(tarefa.getId(), tarefa.getUser().getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
