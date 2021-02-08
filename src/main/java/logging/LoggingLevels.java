package logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingLevels {
    static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {

        logger.setLevel(Level.INFO);
        System.out.println("Log level set as INFO:---------->");
        logger.log(Level.SEVERE,"Uh Oh!!");
        logger.log(Level.INFO,"Just for some info");
        //Below logs will not be printed as the logger level is set as INFO
        logger.log(Level.FINE,"Details ");
        logger.log(Level.FINEST,"Specific details");
    }
}
