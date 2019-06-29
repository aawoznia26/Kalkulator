package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;
import java.util.List;

public class CalculateStatistics implements Statistics {

    Statistics statistics;
    private double usersCount;
    private double postsCount;
    private double commentsCount;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;


    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public List<String> usersNames() {
        List<String> forumUsers = new ArrayList<String>();
        return forumUsers;
    }

    @Override
    public int postsCount() {
        return 0;
    }

    @Override
    public int commentsCount() {
        return 0;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        this.usersCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        this.postsPerUser = postsCount / usersCount;
        this.commentsPerUser = commentsCount / usersCount;
        this.commentsPerPost = commentsCount / postsCount;


    }

    public double[] showStatistics() {
        double[] statisticsToDisplay = {usersCount, postsCount, commentsCount, postsPerUser, commentsPerUser, commentsPerPost};
        return statisticsToDisplay;
    }


}
