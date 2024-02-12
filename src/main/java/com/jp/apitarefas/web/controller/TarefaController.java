package com.jp.apitarefas.web.controller;

import com.jp.apitarefas.entity.Tarefa;
import com.jp.apitarefas.mapper.TarefaMapper;
import com.jp.apitarefas.service.TarefaService;
import com.jp.apitarefas.web.dto.tarefa.TarefaConsultaDTO;
import com.jp.apitarefas.web.dto.tarefa.TarefaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaMapper tarefaMapper;
    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity createTarefa(@Valid @RequestBody TarefaDTO tarefaDTO, UriComponentsBuilder ucb){
        Tarefa tarefa = tarefaService.createTarefa(tarefaMapper.toTarefa(tarefaDTO));
        URI location = ucb
                .path("/api/v1/tarefas/{id}/user/{userId}")
                .buildAndExpand(tarefa.getId(), tarefa.getUser().getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<TarefaConsultaDTO>> getAllTarefasByUser(@PathVariable Integer id){
        List<TarefaConsultaDTO> tarefaDTOList = tarefaMapper.toListTaretaConsultaDTO(tarefaService.getAllTarefasById(id));
        return ResponseEntity.ok(tarefaDTOList);
    }

}
