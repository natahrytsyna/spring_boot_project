package com.codecool.springboot.logger;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {
    @Override
    public Logger getLogger() {
        return Logger.getLogger(getClass());
    }
}
