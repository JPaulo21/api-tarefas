package com.jp.apitarefas.web.mapper;

import com.jp.apitarefas.entity.User;
import com.jp.apitarefas.web.dto.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "enable", constant = "true")
    User toUser(UserDTO userDTO);

}
