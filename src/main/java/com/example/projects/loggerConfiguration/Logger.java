package com.example.projects.loggerConfiguration;

//import org.springframework.boot.logging.LogLevel;

public interface Logger {

    //    void log(LogLevel level, String message);
    String getLogFile();

    void setLogFile(String filePath);

    // Flush the log entries to the file
    void flush();

    // Close the logger and release any resources
    void close();
}
