package com.cv.utilizable.taskmanager;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskContext {

    private Map<String, PersistentIterator> iteratorMap;

    public TaskContext(){
        iteratorMap = new LinkedHashMap<>();
    }

    public PersistentIterator getIterator(String name){

        return iteratorMap.putIfAbsent(name, null); // Todo replace null with default impl
    }
}
