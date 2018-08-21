package kfc.log.utils;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Singleton of LogOfFontDesk4.
 * Make sure two threads (FontDesk4 and a catering thread working on the same order)
 * log into the same log file simultaneously.
 */
public class LogOfFontDesk4 {

    private static LogOfFontDesk4 logOfFontDesk4;
    private static Logger logger;
    private static FileHandler fh;
    private static Formatter sf;

    public LogOfFontDesk4() {
        // Make this class a singleton
        if (logOfFontDesk4 != null) {
            return;
        }

        // Create the log file
        try {
            fh = new FileHandler("./log_font_desk_4.md");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sf = new SimpleFormatter();
        fh.setFormatter(sf);

        logger = Logger.getLogger("kfc.Threads.FontDeskThread4");
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);

        // Part of making this class a singleton
        logOfFontDesk4 = this;
    }

    public Logger getLogger() {
        return LogOfFontDesk4.logger;
    }
}
