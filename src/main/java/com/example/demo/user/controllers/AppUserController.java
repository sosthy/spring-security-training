package com.example.demo.user.controllers;

import com.example.demo.user.criteria.*;
import com.example.demo.user.dtos.AppUserDTO;
import com.example.demo.user.mappers.AppUserMapper;
import com.example.demo.user.models.AppUser;
import com.example.demo.user.services.AppUserService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    List<AppUserDTO> getAllUsers(@RequestParam(value = "search", required = false) String search) {

        UserSpecificationsBuilder builder = new UserSpecificationsBuilder();

        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                System.out.println(matcher.group(1) + " " + matcher.group(2) + " " + matcher.group(3));
                SearchOperation operation = SearchOperation.getSimpleOperation(matcher.group(2).charAt(0));
                builder.with(new SearchCriteria(matcher.group(1), operation, matcher.group(3)));
            }
        }

        Specification<AppUser> spec = builder.build();
        List<AppUser> users = userService.getAllUsers(spec);

        return userMapper.toDTO(users);
    }
}
