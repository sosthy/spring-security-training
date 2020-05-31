package com.example.demo.user.mappers;

import com.example.demo.user.dtos.AppUserDTO;
import com.example.demo.user.models.AppUser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUserDTO toDTO(AppUser user);

    List<AppUserDTO> toDTO(List<AppUser> users);

    AppUser toEntity(AppUserDTO userDTO);

}
