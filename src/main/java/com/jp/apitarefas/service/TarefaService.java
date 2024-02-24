package com.jp.apitarefas.service;

import com.jp.apitarefas.entity.Tarefa;
import com.jp.apitarefas.repositories.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.lang.Boolean.FALSE;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa createTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }


    /**
     * @param id Código do usuário
     * @return Uma lista de tarefas vinculadas ao usuário
     */
    public List<Tarefa> getAllTarefasById(Integer id) {
        return tarefaRepository.findByUserIdAndEnableTrue(id);
    }

    /**
     * @param id
     * @return exclusão lógica da tarefa
     */
    @Transactional
    public void disableTarefa(Integer id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Não existe tarefa com o id = %s", id))
        );
        tarefa.setEnable(FALSE);
    }
}
