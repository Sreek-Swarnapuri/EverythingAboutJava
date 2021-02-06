package appExecutionAndEnvironment.properties;

public class ExecutionEnvironmentInformation {

    public static void main(String[] args) {
        //We can access system properties via System.getProperty() method
        System.out.println("Printing the list of System Properties:");
        System.out.println("---------------------------------------");
        System.out.println("User Name: " +System.getProperty("user.name"));
        System.out.println("User Home: " +System.getProperty("user.home"));
        System.out.println("OS Arch: " + System.getProperty("os.arch"));
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));

        //Environment variables
        System.out.println("Printing the list of Environment variables:");
        System.out.println("-------------------------------------------");

        System.getenv().forEach((k,v) -> System.out.println(k + " : " + v));

        //Accessing one env variable via System.getenv(name)
        System.out.println("Accessing a specific environment variable:");
        System.out.println("------------------------------------------");

        //App Specific Environment Variables
        System.out.println("JAVA_HOME: "+ System.getenv("JAVA_HOME"));
    }

}
