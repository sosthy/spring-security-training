package com.example.demo.role.mappers;

import com.example.demo.role.dtos.AppRoleDTO;
import com.example.demo.role.models.AppRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppRoleMapper {

    AppRoleDTO toDTO(AppRole role);

    List<AppRoleDTO> toDTO(List<AppRole> roles);

    AppRole fromDTO(AppRoleDTO roleDTO);
}
