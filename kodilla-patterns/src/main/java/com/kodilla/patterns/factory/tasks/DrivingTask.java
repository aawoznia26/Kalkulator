package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private String taskName;
    private String where;
    private String using;
    private boolean ifExecuted;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    public boolean executeTask() {
        System.out.println("Drive to " + where + " by " + using + ". " + taskName + " has been executed");
        return ifExecuted = true;
    }

    ;

    public String getTaskName() {
        return taskName;
    }

    public boolean isTaskExecuted() {
        return ifExecuted;
    }

    ;
}
