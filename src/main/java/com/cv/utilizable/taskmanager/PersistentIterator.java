package com.cv.utilizable.taskmanager;

import com.cv.utilizable.taskmanager.beans.DBListImpl;

import java.util.List;

public interface PersistentIterator extends Iterable{

    void add(String code);
    DBListImpl get(String code);
    DBListImpl get(String code, Object def);

    void completed(String code);
    Boolean getStatus(String code);

    boolean remove(String code);

    boolean clearAll();

    List<DBListImpl> getAllIncompletedElements();

    List<DBListImpl> getAllCompletedElements();

    PersistentIterator loadFromDBInternal(String iteratorName);
}
