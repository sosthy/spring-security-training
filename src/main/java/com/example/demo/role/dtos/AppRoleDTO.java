package com.example.demo.role.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor @AllArgsConstructor
public class AppRoleDTO {

    private Long id;

    @NotNull @NotEmpty
    private String roleName;

    private String description;


}
