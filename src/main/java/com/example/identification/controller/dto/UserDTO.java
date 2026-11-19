package com.example.identification.controller.dto;

import java.util.List;

public record UserDTO(String name,
                      String password,
                      List<String> roles) {
}
