package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String textToDecorate, PoemDecorator poemDecorator) {
        return poemDecorator.decorate(textToDecorate);
    }
}
