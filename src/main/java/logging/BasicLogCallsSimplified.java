package logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BasicLogCallsSimplified {
    //Create a logger directly for a class and get the logger from LogManger instead of creating separate instances
    static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        logger.log(Level.INFO,"My First log message");
        logger.log(Level.INFO,"Another message");
    }
}
