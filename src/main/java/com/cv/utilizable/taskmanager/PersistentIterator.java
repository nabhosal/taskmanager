package com.cv.utilizable.taskmanager;

public interface PersistentIterator extends Iterable{

    void add(String id);
    void add(String id, boolean completed);

    void completed(String id);
    boolean get(String id);

    boolean remove(String id);

    boolean clearAll();

    PersistentIterator getAllIncompleteIds();

}
