package com.jp.apitarefas.mapper;

import com.jp.apitarefas.entity.User;
import com.jp.apitarefas.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ObjectFactory;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "enable", constant = "true")
    User toUser(UserDTO userDTO);

}
