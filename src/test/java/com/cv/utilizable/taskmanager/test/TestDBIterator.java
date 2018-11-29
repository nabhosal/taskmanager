package com.cv.utilizable.taskmanager.test;

import com.cv.utilizable.taskmanager.beans.DBIterator;
import com.cv.utilizable.taskmanager.beans.EBeanSetup;
import org.junit.Assert;
import org.junit.Test;

public class TestDBIterator {

    @Test
    public void testInsertAndSave(){

        EBeanSetup.initialize();
        DBIterator dbIterator = new DBIterator();
        dbIterator.setName("Test1");
        dbIterator.save();

        String name = DBIterator.find.ref(1L).getName();
        Assert.assertEquals("name are not equals", name, "Test1");

    }
}
