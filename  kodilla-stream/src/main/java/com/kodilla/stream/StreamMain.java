package com.kodilla.stream;

import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String textToDecorate1 = "Freddie Mercury";
        String textToDecorate2 = "Michael Jackson";
        String decor1 ="★·.·´¯`·.·★";
        String decor2 = "•♬•♫•.";



        System.out.println(poemBeautifier.beautify(textToDecorate1, (text) -> {
            for (int i = 0; i < textToDecorate1.length(); i++){
                if (i == 0) {
                    text = textToDecorate1.charAt(i) + "♡";
                } else {
                    text += textToDecorate1.charAt(i) + "♡";
                }
            }

            return text;
        }));

        System.out.println(poemBeautifier.beautify(textToDecorate1, (text) -> textToDecorate2.toUpperCase()));
        System.out.println(poemBeautifier.beautify(textToDecorate1, (text) -> decor1 + textToDecorate1 + decor1));
        System.out.println(poemBeautifier.beautify(textToDecorate2, (text) -> decor2 + textToDecorate2 + decor2));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
