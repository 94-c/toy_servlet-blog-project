package com.blog.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ExceptionUtil extends RuntimeException{

    private final Logger log = Logger.getLogger("log4j.properties");

    public ExceptionUtil(String message, Level level) {
        super(message);
        log.log(level, message);
    }


}