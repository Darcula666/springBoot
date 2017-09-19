package com.gfdz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunner implements CommandLineRunner {
    protected final Logger logger = LoggerFactory.getLogger(StartApplication.class);
    @Override
    public void run(String... strings) throws Exception {
        logger.info("4645456465456465645");
    }
}
