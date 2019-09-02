package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadProperties {
    public static String getProperty(String key) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));
            return props.getProperty(key);
        } catch (IOException ex) {
            Logger.getLogger(ReadProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
