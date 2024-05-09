package com.uoi.softeng.app.model;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_USER("User"),
    ROLE_ADMIN("Admin");

    private final String name;

    private Role(String name) {
        this.name = name;
    }
}