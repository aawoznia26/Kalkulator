package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskQueueTestSuite {

    @Test
    public void testUpdate(){

        //Given
        Student marekZbiec = new Student("Marek Zbiec");
        Student haniaKoszarska = new Student("Hania Koszarska");
        Student martaKrakowska = new Student("Marta Krakowska");;

        Mentor arekPieczarka = new Mentor ("Arek Pieczarka");
        Mentor joasiaPiaseczna = new Mentor ("Joasia Piaseczna");

        marekZbiec.becomeObserver(arekPieczarka);
        haniaKoszarska.becomeObserver(joasiaPiaseczna);
        martaKrakowska.becomeObserver(joasiaPiaseczna);

        Task task1 = new Task(1, "task1");
        Task task2 = new Task(2, "task2");
        Task task3 = new Task(3, "task3");


        //When
        marekZbiec.addDoneTask(task1);
        haniaKoszarska.addDoneTask(task2);
        martaKrakowska.addDoneTask(task3);


        //Then
        assertEquals(1, arekPieczarka.getUpdateCounter());
        assertEquals(2, joasiaPiaseczna.getUpdateCounter());

    }

}
