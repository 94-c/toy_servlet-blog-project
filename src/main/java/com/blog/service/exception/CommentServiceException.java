package com.blog.service.exception;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class CommentServiceException extends ServiceException {

    private final Logger log = Logger.getLogger("log4j.properties");

    public CommentServiceException(String message, Level level) {
        super(message);
        log.log(level, message);
    }

}
