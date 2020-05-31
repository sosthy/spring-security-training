package com.example.demo.security.services;

import com.example.demo.user.models.AppUser;
import com.example.demo.user.services.AppUserService;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserService userService;

    public CustomUserDetailsService(AppUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> result = userService.findUserByUsername(username);

        if(!result.isPresent()) throw new UsernameNotFoundException("Username not found.");

        AppUser user = result.get();

        Set<SimpleGrantedAuthority> roles = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
                .collect(Collectors.toSet());

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> role.getAuthorities())
                .reduce(Sets.newHashSet(), (perms1, perms2) -> Sets.union(perms1, perms2))
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthName()))
                .collect(Collectors.toSet());

        authorities.addAll(roles);

        User userDetails = new User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }

}
