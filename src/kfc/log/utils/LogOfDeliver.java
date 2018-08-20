package kfc.log.utils;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogOfDeliver {

    private static LogOfDeliver logOfDeliver;
    private static Logger logger;
    private static FileHandler fh;
    private static Formatter sf;

    public LogOfDeliver() throws Exception{
        // Make this class a singleton
        if (logOfDeliver != null) {
            return;
        }

        // Create the log file
        fh = new FileHandler("./log_deliver.md");

        sf = new SimpleFormatter();
        fh.setFormatter(sf);

        logger = Logger.getLogger("kfc.Threads.LogOfDeliver");

        if (logger == null) {
            System.out.println("logger is null");
        }

        try {
            logger.addHandler(fh);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Part of making this class a singleton
        logOfDeliver = this;
    }

    public Logger getLogger() {
        return LogOfDeliver.logger;
    }
}
