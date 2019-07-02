package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observable {

    private final String name;
    private Mentor studentsMentor;
    private final List<Task> tasks;

    public Student(String name) {
        this.name = name;
        tasks = new ArrayList<>();
    }

    @Override
    public void becomeObserver(Mentor mentor){
        studentsMentor = mentor;
    };

    @Override
    public void addDoneTask(Task task){
        tasks.add(task);
        notifyObserver(task);
    }

    @Override
    public void notifyObserver(Task task){
        studentsMentor.update(this, task);

    };

    public String getName() {
        return name;
    }

    public Mentor getStudentsMentor() {
        return studentsMentor;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
