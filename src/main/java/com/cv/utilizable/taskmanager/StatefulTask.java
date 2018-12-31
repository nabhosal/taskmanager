package com.cv.utilizable.taskmanager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public interface StatefulTask extends Serializable {

    default Map<String, Object> getDefaults(){

        Map<String, Object> defaults = new HashMap<>();

        defaults.put("enable.checkpoint", false);
        defaults.put("enable.logging", false);
        defaults.put("enable.timelogging", false);
        defaults.put("class.logging.impl", "");
        return defaults;
    }

    StatefulTask setOption(String option, Object value);
    Object getOption(String option);

    StatefulTask setOption(Map<String, Object> options);
    Map<String, Object> getOption();

    RunnableTask run(String taskName, RunnableTask task);

    Object getResult();
}
