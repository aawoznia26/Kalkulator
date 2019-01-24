package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultForum = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> (forumUser.getDateOfBirth().compareTo(LocalDate.now().minusYears(20)) < 0))
                .filter(forumUser -> forumUser.getPostsNumber()>=1 )
                .collect(Collectors.toMap(ForumUser::getIdentifier, forumUser -> forumUser));

        theResultForum.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}