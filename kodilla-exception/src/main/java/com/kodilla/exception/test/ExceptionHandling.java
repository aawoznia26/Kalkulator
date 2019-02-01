package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String args[]) throws MyException {
        SecondChallenge secondChallenge = new SecondChallenge();

        try{
            secondChallenge.probablyIWillThrowException(5, 6);
        } catch (Exception e){
            throw new MyException();
        } finally {
            System.out.println("Done");
        }
    }
}
