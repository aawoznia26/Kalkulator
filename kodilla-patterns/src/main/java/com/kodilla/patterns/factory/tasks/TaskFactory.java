package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public boolean executeTask(KindOfTask kindOfTask){
        Task task = null;

        switch (kindOfTask) {
            case SHOPPING:
                task = new ShoppingTask("Shopping on Saturday", "eggs", 8);
                break;

            case PAINTING:
                task = new PaintingTask("Furniture painting", "blue", "commode");
                break;

            case DRIVING:
                task = new DrivingTask("Weekend trip", "Viena", "car");
                break;
        }
        return task.executeTask();
    }
}
