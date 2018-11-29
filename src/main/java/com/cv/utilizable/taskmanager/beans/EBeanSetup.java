package com.cv.utilizable.taskmanager.beans;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;

public class EBeanSetup {

    private EBeanSetup() {
    }

    public static EbeanServer initialize(){
        ServerConfig serverConfig = EBeanServerConfig.getDefault("t4");
        serverConfig.setName("db");

        // set as default and register so that Model can be
        // used if desired for save() and update() etc
        serverConfig.setDefaultServer(true);
        serverConfig.setRegister(true);
        return EbeanServerFactory.create(serverConfig);
    }
}
