package com.example.identification.controller;

import com.example.identification.controller.dto.UserDTO;
import com.example.identification.controller.mapper.UserMapper;
import com.example.identification.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDTO dto){
        var user = userMapper.toModel(dto);

        userService.saveUser(user);
    }

    @GetMapping("/{uuid}")
    public UserDTO getUserById(@PathVariable UUID uuid) {
        var user = userService.getUserById(uuid);

        return userMapper.toDto(user);
    }
}
