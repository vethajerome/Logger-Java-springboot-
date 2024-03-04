package com.example.practise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logcontroller {

   /*private static final Logger logger = LoggerFactory.getLogger(Logcontroller.class);*/

    @RequestMapping("/api")
    public String message() {
        // logger.info("Info enabled");
        // logger.error("Error enabled");
        // logger.debug("Debug enabled");
        return "Test Loging";
    }

}
