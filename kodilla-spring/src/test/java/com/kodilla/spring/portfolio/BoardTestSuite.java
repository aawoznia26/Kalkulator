package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        TaskList toDoList = (TaskList) context.getBean("toDoList");
        TaskList inProgressList = (TaskList) context.getBean("inProgressList");
        TaskList doneList = (TaskList) context.getBean("doneList");

        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().addTaskToList("Sprzątanie");
        board.getInProgressList().addTaskToList("Zmywanie");
        board.getDoneList().addTaskToList("Zakupy");

        //Then
        board.getToDoList().printTasksFromList();
        board.getInProgressList().printTasksFromList();
        board.getDoneList().printTasksFromList();
    }

}
