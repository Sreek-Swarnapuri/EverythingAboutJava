package logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BasicLogCalls {
    public static void main(String[] args) {

        //LogManger retrieves the built in logManager
        LogManager lm = LogManager.getLogManager();
        //Logger then is used to get the logger used by LogManager via Name in constant GLOBAL_LOGGER_NAME
        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.log(Level.INFO,"My First log message");
        logger.log(Level.INFO,"Another message");

    }
}
