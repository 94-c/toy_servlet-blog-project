package com.blog.service.exception;

import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommentServiceException extends ServiceException {

    private final Logger log = Logger.getLogger("log4j.properties");
    public CommentServiceException(String message, Level level) {
        super(message);
        log.log(level, message);
    }

}
