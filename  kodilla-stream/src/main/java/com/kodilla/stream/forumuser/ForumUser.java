package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int identifier;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int postsNumber;

    public ForumUser(final int identifier, final String userName, final char sex, final int year, final int month, final int day, final int postsNumber) {
        this.identifier = identifier;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.postsNumber = postsNumber;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "identifier=" + identifier +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsNumber=" + postsNumber +
                '}';
    }
}
