package com.example.demo.user.services;

import com.example.demo.user.models.AppUser;
import com.example.demo.user.repositories.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;

    public AppUserServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<AppUser> findUserByUsername(String username) {
        Optional<AppUser> user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public AppUser createUser(AppUser newUser) {
        AppUser user = userRepository.save(newUser);
        return user;
    }

    @Override
    public List<AppUser> getAllUsers() {
        List<AppUser> users = userRepository.findAll();
        return users;
    }
}
