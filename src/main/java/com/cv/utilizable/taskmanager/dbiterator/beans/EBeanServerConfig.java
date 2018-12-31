package com.cv.utilizable.taskmanager.dbiterator.beans;

import io.ebean.config.ServerConfig;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class EBeanServerConfig {

    private static Properties getDefaultProperties(){

        Properties properties = new Properties();
        properties.put("ebean.db.ddl.generate", "true");
        properties.put("ebean.db.ddl.run", "true");
        properties.put("datasource.db.username", "test");
        properties.put("datasource.db.password", "test123");
        properties.put("datasource.db.databaseUrl", "jdbc:h2:mem:app2");
        properties.put("datasource.db.databaseDriver", "org.h2.Driver");

        return properties;
    }

    public static ServerConfig getDefault(){

        ServerConfig cfg = new ServerConfig();
        cfg.setDefaultServer(true);
        cfg.loadFromProperties(getDefaultProperties());

        return cfg;
    }

    public static ServerConfig getDefault(String runId){

        ServerConfig cfg = new ServerConfig();
        cfg.setDefaultServer(true);
        Properties properties = getDefaultProperties();
        String tempDirectoryPath = System.getProperty("java.io.tmpdir");
        String dbPath = Paths.get(tempDirectoryPath, runId).toAbsolutePath().toString();
        System.out.println("Default temp directory path: " + dbPath);
        properties.put("datasource.db.databaseUrl", "jdbc:h2:file:"+dbPath);
        if(Files.exists(Paths.get(dbPath+".mv.db")))
            properties.put("ebean.db.ddl.run", "false");

        cfg.loadFromProperties(properties);
        System.out.println("url "+cfg.getDataSourceConfig().getUrl());
        return cfg;
    }

}
