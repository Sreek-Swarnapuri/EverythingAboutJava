package logging;

import java.util.logging.*;

public class LoggingLevelFINE {
    static final Logger logger = Logger.getLogger("logging");
    public static void main(String[] args) {
        //We can output logs to our console via ConsoleHandler
        Handler h = new ConsoleHandler();
        h.setLevel(Level.FINE);
        Formatter f = new SimpleFormatter();
        h.setFormatter(f);
        logger.addHandler(h);
        logger.setLevel(Level.FINE);
        System.out.println("Logging level is: " + logger.getLevel());
        System.out.println("Log level set as FINE:---------->");
        //Everything above FINE will be logged as the logger level is FINE
        logger.log(Level.SEVERE,"Uh Oh!!");
        logger.log(Level.INFO,"Just for some info");
        logger.log(Level.FINE,"Details ");
        logger.log(Level.FINEST,"Specific details");
    }
}
