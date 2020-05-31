package com.example.demo.role.services;

import com.example.demo.role.dtos.AppRoleDTO;
import com.example.demo.role.mappers.AppRoleMapper;
import com.example.demo.role.models.AppRole;
import com.example.demo.role.repositories.AppRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppRoleServiceImpl implements AppRoleService {

    private final AppRoleRepository roleRepository;

    public AppRoleServiceImpl(AppRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public AppRole createRole(AppRole newRole) {
        AppRole role = roleRepository.save(newRole);
        return role;
    }

    @Override
    public List<AppRole> getAllRoles() {
        List<AppRole> roles = roleRepository.findAll();
        return roles;
    }
}
