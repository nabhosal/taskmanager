package com.cv.utilizable.taskmanager.test;

import com.cv.utilizable.taskmanager.PersistentIterator;
import com.cv.utilizable.taskmanager.TaskContext;
import com.cv.utilizable.taskmanager.beans.DBIterator;
import com.cv.utilizable.taskmanager.beans.DBListImpl;
import com.cv.utilizable.taskmanager.beans.EBeanSetup;
import org.junit.Before;
import org.junit.Test;

public class TestStatefullIterator {

    @Before
    public void setup(){
        EBeanSetup.initialize();
    }

    @Test
    public void testCreateAndDeleteIterator(){

        TaskContext taskContext = new TaskContext();
        PersistentIterator iterator = taskContext.getIterator("iter01");

        iterator.add("1");
        iterator.add("2");
        iterator.add("3");
        iterator.add("4");

        System.out.println(iterator.getStatus("3"));
        System.out.println("Before "+iterator.get("3"));
        iterator.completed("3");
        System.out.println("After "+iterator.get("3"));

        System.out.println("Invalid Code "+iterator.get("5"));

        System.out.println("B ClearAll \n"+ DBIterator.find.all());

        iterator.clearAll();
        System.out.println("A ClearAll \n"+ DBIterator.find.all());
    }

    @Test
    public void testCreateAndRetain(){

        EBeanSetup.initialize();
        TaskContext firstContext = new TaskContext();
        PersistentIterator iterator = firstContext.getIterator("iter03");

        iterator.add("1");
        iterator.add("2");
        iterator.add("3");
        iterator.add("4");

        System.out.println(iterator.getStatus("3"));
        System.out.println("Before "+iterator.get("3"));
        iterator.completed("3");
        System.out.println("After "+iterator.get("3"));


        TaskContext secondContext = new TaskContext();
        PersistentIterator iterator1 = secondContext.getIterator("iter03");

        System.out.println("Retain status "+iterator1.get("3"));
    }

    @Test
    public void testDBIteratorMethods(){

        EBeanSetup.initialize();
        TaskContext firstContext = new TaskContext();
        PersistentIterator iterator = firstContext.getIterator("iter03");

        System.out.println("List of completed element "+iterator.getAllCompletedElements().size());
        iterator.getAllCompletedElements().forEach(elem -> {
            System.out.println(elem);
        });

        System.out.println("List of InCompleted element "+iterator.getAllIncompletedElements().size());
        iterator.getAllIncompletedElements().forEach(elem -> {
            System.out.println(elem);
        });
    }
}
