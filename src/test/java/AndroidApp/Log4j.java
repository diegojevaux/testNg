package AndroidApp;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j {

//private static final Logger logger = LogManager.getLogger(Log4j.class);

    public static void main(final String[] args) {

        Logger logger = Logger.getLogger("log4j");
        //PropertyConfigurator.configure("C:\Udemy\Appium\testNg\src\main\resources\log4j.properties");
        logger.debug("this is debug");
        logger.info("This is a Info");
        logger.warn("This is a warn");
        logger.error("this is an error");
        logger.fatal("This a Fatal");


    }

}

