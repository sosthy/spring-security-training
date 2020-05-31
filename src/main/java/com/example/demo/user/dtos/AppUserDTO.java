package com.example.demo.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor @AllArgsConstructor
public class AppUserDTO {

    private Long id;

    @NotNull @NotEmpty
    private String username;

    private boolean active;

}
