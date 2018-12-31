package com.cv.utilizable.taskmanager.dbiterator.test;

import com.cv.utilizable.taskmanager.dbiterator.beans.DBIterator;
import com.cv.utilizable.taskmanager.dbiterator.beans.EBeanSetup;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class TestDBIterator {

    @Test
    public void testInsertAndSave(){

        EBeanSetup.initialize();
        DBIterator dbIterator = new DBIterator();
        String dynamicDBName = String.valueOf(Instant.now().getEpochSecond());
        dbIterator.setName(dynamicDBName);
        dbIterator.save();

        String name = DBIterator.find.byId(dbIterator.getId()).getName();
        Assert.assertEquals("name are not equals", name, dynamicDBName);

    }
}
