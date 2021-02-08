package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingViaFileHandler {

    static Logger logger = Logger.getLogger("logging.LoggingViaFileHandler");
    public static void main(String[] args) {

        try {
            //Creates a log file in the home directory(C:\Users\{userName}\myaap_num.log ) with each file 1000 bytes with 4 rotating files
            FileHandler h = new FileHandler("%h/myapp_%g.log",1000,4);
            h.setLevel(Level.FINE);
            h.setFormatter(new SimpleFormatter());
            logger.setLevel(Level.FINE);
            logger.addHandler(h);
            logger.severe("Uh Oh!!");
            logger.info("Just for some info");
            logger.fine("Details ");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
