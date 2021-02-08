package logging;

import java.util.logging.*;

public class LoggingToConsole {

    static Logger logger = Logger.getLogger("logging");
    public static void main(String[] args) {

        //We can output logs to our console via ConsoleHandler
        Handler h = new ConsoleHandler();
        Formatter f = new SimpleFormatter();

        h.setFormatter(f);

        logger.addHandler(h);
        logger.setLevel(Level.INFO);

        logger.info("We're Logging!");

    }
}
