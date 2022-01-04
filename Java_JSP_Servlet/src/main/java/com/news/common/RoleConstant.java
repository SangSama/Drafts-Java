package com.news.common;

public enum RoleConstant {
    ADMIN(1), USER(2);

    private final long role;

    RoleConstant(long role) {
        this.role = role;
    }

    public long role() {
        return role;
    }
}
