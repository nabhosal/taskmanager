package com.cv.utilizable.taskmanager.dbiterator;

import com.cv.utilizable.taskmanager.dbiterator.beans.DBIterator;
import com.cv.utilizable.taskmanager.dbiterator.beans.DBListImpl;
import com.cv.utilizable.taskmanager.dbiterator.beans.EBeanSetup;
import io.ebean.EbeanServer;

public class TestImpl {

    public static void main(String ...args){

        EbeanServer ebeanServer = EBeanSetup.initialize();
        DBIterator iterator = new DBIterator();
        iterator.setName("one");
        iterator.save();

        iterator.add("1");
        iterator.add("3");
        iterator.save();
        DBIterator itr = DBIterator.find.byId(1l);
        System.out.println(itr);
        System.out.println(itr.getDblists().size());
//        System.out.println(itr.getElement("1").toString());

        System.out.println(DBListImpl.find.all());

    }


}
