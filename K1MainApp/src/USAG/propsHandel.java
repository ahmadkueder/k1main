package USAG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propsHandel {

    public static String getProp(String keyName) {
        Properties prop = new Properties();
        try {
            FileInputStream output = new FileInputStream("src/USAG/staticValues.properties");
            prop.load(output);

            
            return prop.getProperty(keyName);
        } catch (IOException ex) {
            System.out.println("erorr prop file not found : " + ex.getMessage());
        }
        return null;
    }
}
