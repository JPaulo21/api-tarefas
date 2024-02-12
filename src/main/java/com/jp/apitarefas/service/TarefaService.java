package com.jp.apitarefas.service;

import com.jp.apitarefas.entity.Tarefa;
import com.jp.apitarefas.repositories.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa createTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> getAllTarefasById(Integer id) {
        return tarefaRepository.findByUserId(id);
    }
}
