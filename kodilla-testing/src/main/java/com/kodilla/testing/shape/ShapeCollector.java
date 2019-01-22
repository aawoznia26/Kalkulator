package com.kodilla.testing.shape;


import java.util.*;

public class ShapeCollector {

    private List<Shape> shapeCollection = new ArrayList<Shape>();


    public void addFigure(Shape shape){
        shapeCollection.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapeCollection.remove(shape);
    }


    public Shape getFigure(int n){
        Shape figure = shapeCollection.get(n);
        return figure;
    }

    public List<Shape> showFigures(){
        return Collections.unmodifiableList(shapeCollection);
    }

    public int listSize(){
        int shapeCollectionSize = shapeCollection.size();
        return shapeCollectionSize;
    }
}
