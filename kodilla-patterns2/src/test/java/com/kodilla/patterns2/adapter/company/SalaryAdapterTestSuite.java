package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SalaryAdapterTestSuite {

    @Test
    public void totalSalaryTest(){
        //Given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();

        //When
        double totalSalary = salaryAdapter.TotalSalary(workers.getWorkers(), workers.getSalaries());

        //Then
        System.out.println(totalSalary);
        assertEquals(totalSalary, 108750, 0);
    }
}
