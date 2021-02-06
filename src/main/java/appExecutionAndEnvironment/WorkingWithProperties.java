package appExecutionAndEnvironment;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class WorkingWithProperties {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("displayName", "Sreekar Swarnapuri");

        //Retrieve a property
        System.out.println("Property of displayName: " + properties.getProperty("displayName"));
        //Property of accountNumber will be null as it does not exist
        System.out.println("Property of accountNumber: " + properties.getProperty("accountNumber"));
        //Retrieve a property with a default value
        System.out.println("Property of position" + properties.getProperty("position","1"));


        //Creating a properties file from our code:
        properties = new Properties();
        properties.setProperty("displayName","Sreekar Swarnapuri");
        properties.setProperty("accountNumber","987-65-4321");

        //We can use the root path and just give the name as xyz.properties which will create the properties
        // file in the root directory
        try(Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/xyz.properties"))){
            properties.store(writer,"My First Properties file");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        //Loading the properties file from a Simple text file
        properties = new Properties();
        try(Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/myapp.properties"))){
            properties.load(reader);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        //Basic property assignment -
        // val1=hello world
        System.out.println("Val1: " + properties.getProperty("val1"));
        //App ignores whitespaces surrounding =
        //val2 = good morning sun
        System.out.println("Val2: " + properties.getProperty("val2"));
        //We can use : as a separator as well
        //val3:        Hi Noon
        System.out.println("Val3: " + properties.getProperty("val3"));
        //If = or : is not specified, it would take he first space as the separator
        //val4 night bobbi sue
        System.out.println("Val4: " + properties.getProperty("val4"));
        //Additionally we can use = or whitespace or : in the value
        //val5=using equals \= in the value and \:
        System.out.println("Val5: " + properties.getProperty("val5"));

        //XML properties file
        //can be loaded from or stored to xml files
        properties = new Properties();
        properties.setProperty("displayName","Sreekar Swarnapuri");
        properties.setProperty("accountNumber","987-65-4321");

        //We can use the root path and just give the name as xyz.properties which will create the properties
        // file in the root directory
        try(OutputStream out = Files.newOutputStream(Paths.get("src/main/resources/properties.xml"))){
            properties.storeToXML(out,"My First Properties file");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        //Loading the properties file from a Simple text file
        try(InputStream in = Files.newInputStream(Paths.get("src/main/resources/properties.xml"))){
            properties.loadFromXML(in);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

    }

}
