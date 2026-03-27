package fileOperations;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {

    public  Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("resource.properties")) {
            properties.load(is);
            System.out.println(properties);
        } catch (Exception exception) {
            //
        }
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = new PropertiesDemo().getProperties();
        System.out.println(properties);

    }
}
