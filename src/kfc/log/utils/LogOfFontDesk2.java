package kfc.log.utils;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Singleton of LogOfFontDesk2.
 * Make sure two threads (FontDesk2 and a catering thread working on the same order)
 * log into the same log file simultaneously.
 */
public class LogOfFontDesk2 {

    private static LogOfFontDesk2 logOfFontDesk2;
    private static Logger logger;
    private static FileHandler fh;
    private static Formatter sf;

    public LogOfFontDesk2() {
        // Make this class a singleton
        if (logOfFontDesk2 != null) {
            return;
        }

        // Create the log file
        try {
            fh = new FileHandler("./log_font_desk_2.md");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sf = new SimpleFormatter();
        fh.setFormatter(sf);

        logger = Logger.getLogger("kfc.Threads.FontDeskThread2");
        logger.addHandler(fh);

        // Part of making this class a singleton
        logOfFontDesk2 = this;
    }

    public Logger getLogger() {
        return LogOfFontDesk2.logger;
    }
}
