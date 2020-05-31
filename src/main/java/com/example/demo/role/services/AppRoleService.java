package com.example.demo.role.services;


import com.example.demo.role.models.AppRole;

import java.util.List;

public interface AppRoleService {

    AppRole createRole(AppRole newRole);

    List<AppRole> getAllRoles();

}
