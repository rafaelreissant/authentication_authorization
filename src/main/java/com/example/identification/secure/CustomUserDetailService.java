package com.example.identification.secure;

import com.example.identification.model.UserModel;
import com.example.identification.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userService.getByLogin(username);

        if (userModel == null){
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username(userModel.getName())
                .password(userModel.getPassword())
                .roles(userModel.getRoles().toArray(new String[userModel.getRoles().size()]))
                .build();
    }
}
