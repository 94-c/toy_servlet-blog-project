package com.blog.service.exception;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class PostServiceException extends RuntimeException{

    private final Logger log = Logger.getLogger("log4j.properties");

    public PostServiceException(String message, Level level) {
        super(message);
        log.log(level, message);
    }


}