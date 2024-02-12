package com.jp.apitarefas.mapper;

import com.jp.apitarefas.entity.Tarefa;
import com.jp.apitarefas.entity.User;
import com.jp.apitarefas.service.UserService;
import com.jp.apitarefas.web.dto.TarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserService.class})
public interface TarefaMapper {

    @Mapping(target = "user", source = "userId")
    @Mapping(target = "enable", constant = "true")
    Tarefa toTarefa(TarefaDTO tarefaDTO);

    default User mapUserIdToUser(Integer userId, UserService userService){
        return userService.findById(userId);
    }
}
