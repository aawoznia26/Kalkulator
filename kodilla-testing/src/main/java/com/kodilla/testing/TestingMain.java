package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("a", "a");

        String result = simpleUser.getUsername();

        if (result.equals("a")) {
            System.out.println("test1 OK");
        } else {
            System.out.println("test1 Error!");
        }

        Calculator calculator = new Calculator();
        int var1 = 5;
        int var2 = 8;

        if (calculator.add(var1, var2) == 13) {
            System.out.println("test2 OK");
        } else {
            System.out.println("test2 Error!");
        }


        if (calculator.substract(var1, var2) == -3) {
            System.out.println("test3 OK");
        } else {
            System.out.println("test3 Error!");
        }

    }
}
