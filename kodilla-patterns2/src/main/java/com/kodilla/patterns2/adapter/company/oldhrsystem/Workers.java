package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String [][] workers = {
            {"73738393930033", "john", "smith"},
            {"63673788349939", "maria", "walker"},
            {"19283734792022", "nathan", "lehmann"},
            {"53638899339093", "viktor", "samsodan"},
            {"01978736366635", "thomas", "peres"}};

    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            90000.00,
            6200.00};

    public String getWorker(int n) {
        if(n > salaries.length) {
            return "";
        }
        return workers[n][0]  + ", " + workers[n][1] + ", " + workers[n][2] + "," + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
