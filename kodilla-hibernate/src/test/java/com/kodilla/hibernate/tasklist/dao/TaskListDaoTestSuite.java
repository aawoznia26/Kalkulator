package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName(){

        //Given
        String listName = "Sport Activities";
        TaskList taskList = new TaskList(listName, "List of sport activities to do in current week");
        taskListDao.save(taskList);
        //When
        List<TaskList> foundLists = taskListDao.findByListName(listName);
        //Then
        Assert.assertEquals(1, foundLists.size());
        //CleanUp
        int id = foundLists.get(0).getId();
        taskListDao.deleteById(id);
    }
}
