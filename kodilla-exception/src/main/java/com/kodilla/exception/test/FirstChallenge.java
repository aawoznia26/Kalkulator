package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

        /**
         * This main can throw an ArithmeticException!!!
         * @param args
         */
        public static void main (String[]args){

            FirstChallenge firstChallenge = new FirstChallenge();

            try {
                System.out.println("Wynik dzielenia: " + firstChallenge.divide(3, 0));
            } catch (ArithmeticException e) {
                System.out.println("Pamiętaj cholero nigdy nie dziel przez 0!");
            } finally {
                System.out.println("Koniec");
            }

        }
    }

