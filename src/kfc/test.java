package kfc;

import java.io.IOException;
import java.util.logging.*;

public class test {

    public static void main(String[] args) throws SecurityException, IOException {
    //日志记录器
        Logger logger = Logger.getLogger("chapter07");
    //日志处理器
        FileHandler fileHandler = new FileHandler("/Users/joy/Desktop/test.md");

    //需要记录的日志消息

        LogRecord lr = new LogRecord(Level.INFO, "\n> # This is a text log.\n");
        LogRecord lr1 = new LogRecord(Level.INFO, "\n> > ###This is a text log.");

    //为处理器设置日志格式：Formatter

        SimpleFormatter sf = new SimpleFormatter();

        fileHandler.setFormatter(sf);
    //注册处理器
        logger.addHandler(fileHandler);
    //记录日志消息
        logger.log(lr);
        logger.log(lr1);

        }

}
