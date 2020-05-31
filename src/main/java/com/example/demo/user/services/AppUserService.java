package com.example.demo.user.services;

import com.example.demo.user.models.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    Optional<AppUser> findUserByUsername(String username);

    AppUser createUser(AppUser newUser);

    List<AppUser> getAllUsers();

}
