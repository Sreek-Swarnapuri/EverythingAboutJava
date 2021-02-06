package appExecutionAndEnvironment.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class WorkingWithDefaultProperties {
    public static void main(String[] args) {
        try {
            Properties defaultProps = new Properties();
            try (InputStream in = Files.newInputStream(Paths.get("default.properties"))) {
                defaultProps.load(in);
            }

            Properties userProps = new Properties(defaultProps);
            loadUserProps(userProps);

            String welcomeMessage = userProps.getProperty("welcomeMessage");
            String farewellMessage = userProps.getProperty("farewellMessage");

            System.out.println(welcomeMessage);
            System.out.println(farewellMessage);

            if(userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")) {
                userProps.setProperty("welcomeMessage","Welcome Back");
                userProps.setProperty("farewellMessage","Things will be familiar now");
                userProps.setProperty("isFirstRun","N");

                saveUserProps(userProps);
            }


        } catch (IOException exception) {
            System.out.println("Exception <" + exception.getClass().getSimpleName() + "> " + exception.getMessage());
        }
    }

    public static Properties loadUserProps(Properties properties) {
        if (Files.exists(Paths.get("user.properties")))
            try (InputStream in = Files.newInputStream(Paths.get("user.properties"))) {
                properties.load(in);
            } catch (Exception exception) {
                System.out.println("Exception <" + exception.getClass().getSimpleName() + "> " + exception.getMessage());
            }
        return properties;
    }

    public static void saveUserProps(Properties properties) throws IOException {
        try(OutputStream out = Files.newOutputStream(Paths.get("user.properties"))){
            properties.store(out,"Updated user Properties");
        }
    }

}
