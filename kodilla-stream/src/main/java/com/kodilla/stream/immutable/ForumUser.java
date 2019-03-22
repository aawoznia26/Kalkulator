package com.kodilla.stream.immutable;

public final class ForumUser {
    private final String username;
    private final String realName;

    private ForumUser(final String username, final String realName) {
        this.username = username;
        this.realName = realName;
    }

    private String getUsername() {
        return username;
    }

    private String getRealName() {
        return realName;
    }

}
