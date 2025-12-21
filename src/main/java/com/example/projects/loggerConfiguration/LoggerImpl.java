package com.example.projects.loggerConfiguration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//import org.springframework.boot.logging.LogLevel;

public class LoggerImpl implements Logger {
    private static LoggerImpl instance;

    private PrintWriter writer;
    private String logFilePath;

    private LoggerImpl() {

    }

//    @Override
//    public void log(LogLevel level, String message) {
//        /**
//         * void log(LogLevel level, String message): This method is responsible for logging a message with a specified log level. The log message should include a timestamp, log level, and the provided message. Throw an IllegalStateException if the logger is not initialised using the setLogFile() method.
//         */
//        if (writer == null) {
//            throw new IllegalStateException("Logger.java is not initialised. Call setLogFile() first.");
//        }
//
//        if (level == null) {
//            throw new IllegalArgumentException("level must not be null");
//        }
//
//        if (message == null) {
//            message = "null";
//        }
//        String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
//        writer.printf("%s [%s] %s%n", timestamp, level, message);
//
//        if (writer.checkError()) {
//            throw new IllegalStateException("Failed to write log entry to file: " + logFilePath);
//        }
//    }

    public static LoggerImpl getInstance() {
        if (instance == null) {
            synchronized (LoggerImpl.class) {
                if (instance == null) {
                    instance = new LoggerImpl();
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    @Override
    public String getLogFile() {
        /**
         * String getLogFile(): This method returns the current log file path.
         */
        return logFilePath;
    }

    @Override
    public void setLogFile(String filePath) {
        /**
         * void setLogFile(String filePath): This method sets the log file path. The logger will write log messages to this file. Look at using the java.io.PrintWriter and java.io.FileWriter classes to write to the log file. You can initialise them in this method.
         */
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("filePath must not be null/blank");
        }

        // If already initialised, close old writer first to avoid leaking handles
        if (writer != null) {
            writer.close();
            writer = null;
        }

        try {
            // Append = true so logs accumulate
            FileWriter fileWriter = new FileWriter(filePath, true);
            // autoFlush=true flushes on println/printf/format calls
            this.writer = new PrintWriter(fileWriter, true);
            this.logFilePath = filePath;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to open log file: " + filePath, e);
        }
    }

    @Override
    public void flush() {
        /**
         * void flush(): This method flushes any buffered log entries to the log file. Find the appropriate method to use from the java.io.PrintWriter class.
         */
        writer.flush();
    }

    @Override
    public void close() {
        /**
         * void close(): This method closes the logger and releases any resources. Find the appropriate method to use from the java.io.PrintWriter class.
         */
        if (writer == null) {
            throw new IllegalStateException("Logger.java is not initialised. Call setLogFile() first.");
        }
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}
