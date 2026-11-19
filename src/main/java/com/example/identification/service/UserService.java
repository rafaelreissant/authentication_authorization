package com.example.identification.service;

import com.example.identification.model.UserModel;
import com.example.identification.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void saveUser(UserModel userModel){
        var password = userModel.getPassword();
        userModel.setPassword(encoder.encode(password));

        userRepository.save(userModel);
    }

    public UserModel getByLogin(String name){
        return userRepository.findByName(name);
    }

    public UserModel getUserById(UUID uuid) {
        return userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}