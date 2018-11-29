package com.cv.utilizable.taskmanager;

import com.cv.utilizable.taskmanager.PersistentIterator;
import com.cv.utilizable.taskmanager.beans.DBIterator;

import java.util.Iterator;

public class PersistentIteratorImpl implements PersistentIterator {

    private DBIterator dbIterator;

    public PersistentIteratorImpl(String name){
        dbIterator = new DBIterator();
        dbIterator.setName(name);
        dbIterator.save();
        dbIterator.flush(); // model way-of commit stmt
    }

    @Override
    public void add(String id) {

    }

    @Override
    public void add(String id, boolean completed) {

    }

    @Override
    public void completed(String id) {

    }

    @Override
    public boolean get(String id) {
        return false;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public boolean clearAll() {
        return false;
    }

    @Override
    public PersistentIterator getAllIncompleteIds() {
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return null;
    }
}
