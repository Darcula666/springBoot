package com.gfdz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MyStartupRunner implements ApplicationRunner {
    protected final Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        logger.info(UUID.randomUUID().toString().replace("-",""));

    }
}
