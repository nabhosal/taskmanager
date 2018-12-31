package com.cv.utilizable.taskmanager;

import com.cv.utilizable.taskmanager.dbiterator.PersistentIterator;
import com.cv.utilizable.taskmanager.dbiterator.PersistentIteratorImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskContext {

    private Map<String, PersistentIterator> iteratorMap;

    public TaskContext(){
        iteratorMap = new LinkedHashMap<>();
    }

    public PersistentIterator getIterator(String name){

        if(!iteratorMap.containsKey(name))
            iteratorMap.put(name, PersistentIteratorImpl.loadFromDB(name));
        return iteratorMap.get(name);
    }
}
