package com.kodilla;

public class Calculator {
    private int a;
    private int b;

    public int addVariables(int a, int b) {
        return a + b;
    }

    public int substractVariables(int a, int b) {
        return a - b;
    }

    public static void main(String args[]) {
        Calculator calculator = new Calculator();
        calculator.addVariables(3, 4);
    }

}
