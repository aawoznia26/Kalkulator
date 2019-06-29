package com.kodilla.exception.test;

public class ExceptionHandling {
    public void handleException() throws MyException {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(5, 6);
        } catch (Exception e) {
            throw new MyException();
        }
    }
}
