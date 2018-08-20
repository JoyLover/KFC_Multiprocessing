package kfc.log.utils;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogOfFontDesk3 {

    private static LogOfFontDesk3 logOfFontDesk3;
    private static Logger logger;
    private static FileHandler fh;
    private static Formatter sf;

    public LogOfFontDesk3() {
        // Make this class a singleton
        if (logOfFontDesk3 != null) {
            return;
        }

        // Create the log file
        try {
            fh = new FileHandler("./log_font_desk_3.md");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sf = new SimpleFormatter();
        fh.setFormatter(sf);

        logger = Logger.getLogger("kfc.Threads.FontDeskThread3");
        logger.addHandler(fh);

        // Part of making this class a singleton
        logOfFontDesk3 = this;
    }

    public Logger getLogger() {
        return LogOfFontDesk3.logger;
    }
}
