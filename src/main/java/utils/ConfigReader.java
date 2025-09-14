package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties propertie;

    static {
        try{
            propertie = new Properties();
            FileInputStream file = new FileInputStream("Config/config.properties");
            propertie.load(file);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return propertie.getProperty(key);
    }

}
