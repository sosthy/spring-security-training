package com.example.demo.role.controllers;

import com.example.demo.role.dtos.AppRoleDTO;
import com.example.demo.role.mappers.AppRoleMapper;
import com.example.demo.role.models.AppRole;
import com.example.demo.role.services.AppRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class AppRoleController {

    private final AppRoleService roleService;
    private final AppRoleMapper roleMapper;

    public AppRoleController(AppRoleService roleService, AppRoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @GetMapping
    public List<AppRoleDTO> getAllRoles() {
        List<AppRole> roles = roleService.getAllRoles();
        return roleMapper.toDTO(roles);
    }

}
