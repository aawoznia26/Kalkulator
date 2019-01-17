package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    List<Integer> evenNumbers = new ArrayList<Integer>();

    public OddNumbersExterminator() {
        this.evenNumbers = evenNumbers;
    }

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
       for (Integer theNumber:numbers) {
           if ((theNumber % 2) == 0) {
               evenNumbers.add(theNumber);
           }
       }
       return new ArrayList<Integer>(evenNumbers);
   }
}
