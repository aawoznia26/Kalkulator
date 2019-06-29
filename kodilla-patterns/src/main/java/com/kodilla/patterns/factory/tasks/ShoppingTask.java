package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private String taskName;
    private String whatToBuy;
    private double quantity;
    private boolean ifExecuted;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    public boolean executeTask() {
        System.out.println("Buy " + whatToBuy + " " + quantity + ". " + taskName + " has been executed");
        return ifExecuted = true;
    }

    ;

    @Override
    public String getTaskName() {
        return taskName;
    }

    public boolean isTaskExecuted() {
        return ifExecuted;
    }

    ;
}
