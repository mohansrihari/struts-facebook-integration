package com.mohansrihari.common;

import org.apache.log4j.Logger;

/**
 * This class is used for the logging activity of the application.
 * 
 * @author KMohan
 */
public class AppLogger {
	static Logger logger;

	/**
	 * Create an instance of the AppLogger for logging.
	 * 
	 * @param loggingClass
	 */
	@SuppressWarnings("unchecked")
	public AppLogger(Class loggingClass) {
		logger = Logger.getLogger(loggingClass);
	}

	/**
	 * Print the message as an information.
	 * 
	 * @param message
	 */
	public void info(Object message) {
		logger.info(message);
	}

	/**
	 * Print the message as an error.
	 * 
	 * @param throwable
	 */
	public void error(Throwable throwable) {
		logger.error(throwable);
	}
}
