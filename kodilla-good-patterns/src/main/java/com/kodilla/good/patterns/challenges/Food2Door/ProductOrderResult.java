package com.kodilla.good.patterns.challenges.Food2Door;

public class ProductOrderResult {
    private int pieces;
    private boolean result;

    public ProductOrderResult(int pieces, boolean result) {
        this.pieces = pieces;
        this.result = result;
    }

    public int getPieces() {
        return pieces;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}