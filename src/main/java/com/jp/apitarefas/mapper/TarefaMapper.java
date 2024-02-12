package com.jp.apitarefas.mapper;

import com.jp.apitarefas.entity.Tarefa;
import com.jp.apitarefas.entity.User;
import com.jp.apitarefas.service.UserService;
import com.jp.apitarefas.web.dto.tarefa.TarefaConsultaDTO;
import com.jp.apitarefas.web.dto.tarefa.TarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserService.class})
public interface TarefaMapper {

    @Mapping(target = "user", source = "userId")
    @Mapping(target = "enable", constant = "true")
    Tarefa toTarefa(TarefaDTO tarefaDTO);

    List<TarefaConsultaDTO> toListTaretaConsultaDTO(List<Tarefa> tarefas);

    default User mapUserIdToUser(Integer userId, UserService userService){
        return userService.findById(userId);
    }

}
