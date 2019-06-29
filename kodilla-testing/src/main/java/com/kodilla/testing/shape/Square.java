package com.kodilla.testing.shape;

public class Square implements Shape {
    private double lengthOfSide;

    public Square(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        double field = lengthOfSide * lengthOfSide;
        return field;
    }
}
