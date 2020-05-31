package com.example.demo.security.models.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.security.models.enums.AppAuthorityEnum.*;

public enum AppRoleEnum {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, ROLE_READ, ROLE_WRITE));

    private final Set<AppAuthorityEnum> permissions;

    AppRoleEnum(Set<AppAuthorityEnum> permissions) {
        this.permissions = permissions;
    }

    public Set<AppAuthorityEnum> getPermissions() {
        return permissions;
    }
}
