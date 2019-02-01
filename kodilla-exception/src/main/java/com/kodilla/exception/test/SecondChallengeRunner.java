package com.kodilla.exception.test;

public class SecondChallengeRunner {

    public static void main(String args[]){
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        try{
            exceptionHandling.handleException();
        } catch (MyException e) {
            System.out.println("Oh no, MyException!");
        } finally {
            System.out.println("Done");
        }
    }
}
