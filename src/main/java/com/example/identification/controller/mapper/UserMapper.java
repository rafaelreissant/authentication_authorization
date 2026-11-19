package com.example.identification.controller.mapper;

import com.example.identification.controller.dto.UserDTO;
import com.example.identification.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserModel toModel(UserDTO dto);

    UserDTO toDto(UserModel model);
}
