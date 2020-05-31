package com.example.demo.init;

import com.example.demo.role.models.AppRole;
import com.example.demo.role.services.AppRoleService;
import com.example.demo.security.models.AppAuthority;
import com.example.demo.security.models.enums.AppAuthorityEnum;
import com.example.demo.security.repositories.AppAuthorityRepository;
import com.example.demo.user.models.AppUser;
import com.example.demo.user.services.AppUserService;
import com.google.common.collect.Sets;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.security.models.enums.AppRoleEnum.ADMIN;
import static com.example.demo.security.models.enums.AppRoleEnum.USER;

@Component
public class ApplicationInit implements CommandLineRunner {

    private final AppRoleService roleService;
    private final AppUserService userService;
    private final AppAuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public ApplicationInit(AppRoleService roleService, AppUserService userService, AppAuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        List<AppAuthority> authorities = new ArrayList<>();

        for(int i = 0; i < AppAuthorityEnum.values().length; i++) {
            AppAuthority authority = new AppAuthority();
            authority.setCode(AppAuthorityEnum.values()[i].name());
            authority.setAuthName(AppAuthorityEnum.values()[i].getName());
            authority.setDescription(AppAuthorityEnum.values()[i].getDescription());
            authorities.add(authorityRepository.save(authority));
        }

        AppRole roleAdmin = new AppRole();
        roleAdmin.setRoleName(ADMIN.name());
        roleAdmin.setDescription("Administrateur général de l'application");
        roleAdmin.setAuthorities(Sets.newHashSet(authorities));
        roleAdmin = roleService.createRole(roleAdmin);

        AppRole roleUser = new AppRole();
        roleUser.setRoleName(USER.name());
        roleUser.setDescription("Simple utilisateur sans autorisation");
        roleUser.setAuthorities(Sets.newHashSet());
        roleUser = roleService.createRole(roleUser);

        AppUser admin = new AppUser();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRoles(Sets.newHashSet(roleAdmin, roleUser));
        userService.createUser(admin);

        AppUser user = new AppUser();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setRoles(Sets.newHashSet(roleUser));
        userService.createUser(user);
    }

}
