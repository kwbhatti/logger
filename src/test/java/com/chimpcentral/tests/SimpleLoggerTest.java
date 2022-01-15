package com.chimpcentral.tests;

import com.chimpcentral.simpleLogger.Log;
import com.chimpcentral.simpleLogger.Logger;
import com.chimpcentral.simpleLogger.LoggerOptions;

public class SimpleLoggerTest {

	public static void main(String[] args) {
		
		LoggerOptions loggerOptions = new LoggerOptions("mytargetdir")
												.setFilename("mylogs.html")
												.setTitle("My title")
												.setHeading("My Heading")
												.setSubHeading("my sub heading");
		
		Logger logger = new Logger(loggerOptions);
		loggerOptions = logger.getLoggerOptions();
		
		System.out.println(loggerOptions.getTargetDir());
		System.out.println(loggerOptions.getFilename());
		System.out.println(loggerOptions.getFilepath());
		System.out.println(loggerOptions.getTitle());
		System.out.println(loggerOptions.getHeading());
		System.out.println(loggerOptions.getSubHeading());
		
		
		Log log1 = logger.createLog("Log 1");
		log1.info("log 1 message");
		Log log2 = logger.createLog("Log 2");
		log2.info("log 2 message");
		Log log3 = logger.createLog("Log 3");
		Log log4 = logger.createLog("Log 4");

	}
}
