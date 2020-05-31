package com.example.demo.user.controllers;

import com.example.demo.user.dtos.AppUserDTO;
import com.example.demo.user.mappers.AppUserMapper;
import com.example.demo.user.models.AppUser;
import com.example.demo.user.services.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class AppUserController {

    private final AppUserService userService;
    private final AppUserMapper userMapper;

    public AppUserController(AppUserService userService, AppUserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    List<AppUserDTO> getAllUsers() {
        List<AppUser> users = userService.getAllUsers();
        return userMapper.toDTO(users);
    }
}
