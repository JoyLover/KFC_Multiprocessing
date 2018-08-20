package kfc.log.utils;

import java.util.logging.*;

/**
 * Singleton of LogOfFontDesk1.
 * Make sure two threads (FontDesk1 and a catering thread working on the same order)
 * log into the same log file simultaneously.
 */
public class LogOfFontDesk1 {

    private static LogOfFontDesk1 logOfFontDesk1;
    private static Logger logger;
    private static FileHandler fh;
    private static Formatter sf;

    public LogOfFontDesk1() throws Exception{
        // Make this class a singleton
        if (logOfFontDesk1 != null) {
            return;
        }

        // Create the log file
        fh = new FileHandler("./log_font_desk_1.md");

        sf = new SimpleFormatter();
        fh.setFormatter(sf);

        logger = Logger.getLogger("kfc.Threads.FontDeskThread1");

        if (logger == null) {
            System.out.println("logger is null");
        }

        try {
            logger.addHandler(fh);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Part of making this class a singleton
        logOfFontDesk1 = this;
    }

    public Logger getLogger() {
        return LogOfFontDesk1.logger;
    }
}
