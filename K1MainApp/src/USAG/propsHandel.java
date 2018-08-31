package USAG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propsHandel {

    private final String propPath = "changableFiles/staticValues.properties";

    public String getPropPath() {
        return propPath;
    }

    public String getProp(String keyName) {

        Properties prop = new Properties();
        try {
            File file = new File(propPath);
            try (FileInputStream output = new FileInputStream(file)) {
                prop.load(output);
            }
            return prop.getProperty(keyName);
        } catch (IOException ex) {
            System.out.println("erorr prop file not found : " + ex.getMessage());
        }
        return null;
    }

}
