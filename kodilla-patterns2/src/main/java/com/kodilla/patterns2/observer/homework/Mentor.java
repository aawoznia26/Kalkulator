package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String name;
    private int updateCounter;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Student student, Task task){
        System.out.println("Your student " + student.getName() + " has finished task "  + task.getNumber() + ". Do the review.");
        updateCounter ++;
    }

    public int getUpdateCounter() {
        return updateCounter;
    }
}
