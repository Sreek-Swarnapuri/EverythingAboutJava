package logging;

import java.util.logging.Logger;

public class LoggingUsingConfigFile {

    static Logger logger = Logger.getLogger("logging.LoggingUsingConfigFile");
    public static void main(String[] args) {

        logger.severe("Uh Oh!!");
        logger.info("Just for some info");
        logger.fine("Details ");

    }

}
