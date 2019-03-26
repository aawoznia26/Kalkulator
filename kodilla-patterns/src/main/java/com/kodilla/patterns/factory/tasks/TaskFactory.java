package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public Task executeTask(KindOfTask kindOfTask){

        switch (kindOfTask) {
            case SHOPPING:
                return new ShoppingTask("Shopping on Saturday", "eggs", 8);

            case PAINTING:
                return new PaintingTask("Furniture painting", "blue", "commode");

            case DRIVING:
                return new DrivingTask("Weekend trip", "Viena", "car");

            default:
                return null;
        }

    }
}
