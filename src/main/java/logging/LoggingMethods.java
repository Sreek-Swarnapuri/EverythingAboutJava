package logging;

import java.util.logging.*;

public class LoggingMethods {
    static final Logger logger = Logger.getLogger("logging.LoggingMethods");
    public static void main(String[] args) {
        //Logging methods can be used directly instead of passing level as separate parameter
        Handler h = new ConsoleHandler();
        h.setLevel(Level.ALL);
        Formatter f = new SimpleFormatter();
        h.setFormatter(f);
        logger.addHandler(h);
        logger.setLevel(Level.ALL);
        System.out.println("Logging level is: " + logger.getLevel());
        System.out.println("Log level set as ALL:---------->");
        //Everything above FINE will be logged as the logger level is FINE
        logger.severe("Uh Oh!!");
        logger.info("Just for some info");
        logger.fine("Details ");
        logger.finest("Specific details");

        //Precise Log Method to give method and class name as parameters:
        logger.info("Precise Log Method to give method and class name as parameters----------------->");
        logger.logp(Level.SEVERE,"logging.LoggingMethods","main","It Broke!");

        //Entry and Exit methods:
        doWork();

        //Parameterized message Methods:
        logger.info("Parameterized message Methods----------------->");
        logger.log(Level.INFO,"{0} is my fav","Java");
        logger.log(Level.INFO,"{0} is {1} days from {2}",new Object[]{"Wed",2,"Fri"});


    }

    static void doWork() {
        logger.info("Entry and Exit methods----------------->");
        logger.entering("logging.LoggingMethods","doWork");
        logger.logp(Level.WARNING,"logging.LoggingMethods","doWork","Method doesn't do anything");
        logger.exiting("logging.LoggingMethods","doWork");
    }
}
