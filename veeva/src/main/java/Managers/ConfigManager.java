package Managers;

import java.io.FileInputStream;
import java.io.IOException;

import Utilities.FileUtilities;

public class ConfigManager extends ReportManager{

    public ConfigManager(String path) {
        try {
            inputstream = new FileInputStream(FileUtilities.abs(path));
            prop.load(inputstream);
        } catch (IOException e) {
            System.out.println("Config file not found in the path: " + FileUtilities.abs(path));
            report("Config file not found in the path: " + path);
        }
    }

    public ConfigManager() {
        String path = "Configurations/config.properties";
        try {
            inputstream = new FileInputStream(FileUtilities.abs(path));
            prop.load(inputstream);
        } catch (IOException e) {
            System.out.println("Config file not found in the path: " + FileUtilities.abs(path));
            report("Config file not found in the path: " + path);
        }
    }

    public String getFromConfig(String key){
        return prop.getProperty(key);
    }

}
