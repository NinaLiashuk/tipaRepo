package Aston.com.helpers;

import Aston.com.constants.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String propertyName) {

        Properties property = new Properties();

        try (FileInputStream fis = new FileInputStream(Configuration.PATH_PROPERTIES)) {
            property.load(fis);
            return property.getProperty(propertyName);
        } catch (IOException e) {
                      throw new UnsupportedOperationException("Error reading property: " + propertyName);
        }
    }
}