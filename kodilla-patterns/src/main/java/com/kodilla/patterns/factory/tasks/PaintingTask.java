package com.kodilla.patterns.factory.tasks;

public class PaintingTask  implements Task{

    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean ifExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    public boolean executeTask(){
        System.out.println("Color " + whatToPaint + " on color " + color + ". " + taskName +  " has been executed");
        return ifExecuted = true;
    };

    @Override
    public String getTaskName() {
        return taskName;
    }

    public boolean isTaskExecuted(){
        return ifExecuted;
    };
}
