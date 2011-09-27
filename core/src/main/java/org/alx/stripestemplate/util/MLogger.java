package org.alx.stripestemplate.util;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class MLogger {
    private final Logger logger;

    public static MLogger getLogger(Class clazz){
        return new MLogger(clazz);
    }

    private MLogger(Class clazz){
        this.logger = Logger.getLogger(clazz);
    }

    public void debug(String msg) {
        logger.debug(msg);
    }

    public void info(String msg) {
        logger.info(msg);
    }

    public void warn(String msg) {
        logger.warn(msg);
    }

    public void error(String msg) {
        logger.error(msg);
    }

    public void error(String msg, Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        logger.error(msg, e);
    }

}
