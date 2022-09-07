package com.blog.service.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceException extends ServiceException {

    private final Logger log = Logger.getLogger("log4j.properties");

    public UserServiceException(String message, Level level) {
        super(message);
        log.log(level, message);
    }

}
