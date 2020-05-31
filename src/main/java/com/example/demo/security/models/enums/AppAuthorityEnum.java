package com.example.demo.security.models.enums;

public enum AppAuthorityEnum {

    USER_READ("user:read", "Voir la liste des utilisateurs"),
    USER_WRITE("user:write", "Peut apporter des modifications sur l'entité USER"),
    ROLE_READ("role:read", "Voir la liste des roles"),
    ROLE_WRITE("role:write", "Peut apporter des modifications sur l'entité ROLE");

    private final String name;
    private final String description;

    AppAuthorityEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() { return description; }
}
