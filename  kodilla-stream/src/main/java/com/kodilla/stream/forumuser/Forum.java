package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum() {
        forumUsersList.add(new ForumUser(1, "Brajan Wieczorek", 'M', 2000, 12, 1, 435));
        forumUsersList.add(new ForumUser(2, "terminator_1464", 'M', 1978, 9, 23, 435));
        forumUsersList.add(new ForumUser(3, "Kwiatuszek@", 'F', 1985, 8, 6, 435));
        forumUsersList.add(new ForumUser(4, "KasiaP.", 'F', 1996, 3, 13, 435));
        forumUsersList.add(new ForumUser(5, "anonim", 'M', 1993, 4, 30, 435));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsersList);
    }

}
