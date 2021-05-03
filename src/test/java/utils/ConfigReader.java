package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static {
        String path="src/test/resources/configuration.properties";
        try{
            //FileInputStream will open the file
            FileInputStream input=new FileInputStream(path);
            properties=new Properties();
            //load method will store every value from properties file to the Properties object
            properties.load(input);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
    public static String apiPropertyReaderByKey(String key){
        Properties properties=new Properties();

        File propFile =new File("src/test/resources/properties/apiConfigReader.properties");
        try {
            FileInputStream inputStream = new FileInputStream(propFile);
            properties.load(inputStream);
        }catch(IOException ex){
            throw new RuntimeException("apiCredentials.properties file was not found",ex);
        }
        return properties.getProperty(key);
    }

}
