package com.QaUtilityBot.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    private final Properties properties;
    public PropertiesFile(){
        properties= new Properties();
        String basePath= System.getProperty("user.dir");
        System.out.println("Base Path is:: "+basePath);
        String finalPath=basePath+"\\src\\main\\resources\\testConfig.properties";
        System.out.println("Final path is:: "+finalPath);
        try {
            properties.load(new FileInputStream(finalPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getPropertyValue(String key){
       return properties.getProperty(key);
    }
}
