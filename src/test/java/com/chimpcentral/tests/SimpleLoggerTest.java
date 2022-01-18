package com.chimpcentral.tests;

import java.io.FileNotFoundException;
import java.util.UUID;

import com.chimpcentral.simpleLogger.Log;
import com.chimpcentral.simpleLogger.Logger;
import com.chimpcentral.simpleLogger.LoggerOptions;

public class SimpleLoggerTest {

	public static String getRandomString(String message) {
		return message + "\t" + UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()
							+ UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()
							+ UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()
							+ UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()
							+ UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID();
	}
	
	public static void main(String[] args) {
		
		LoggerOptions loggerOptions = new LoggerOptions()
												.setFilename("mylogs.html")
//												.removeImages()
												.setGithubURL("https://github.com/")
												.setJiraURL("https://www.atlassian.com/software/jira")
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
		logger.info(getRandomString("in main logger"));
		logger.info(getRandomString("in main logger"));
		logger.warn(getRandomString("in main logger"));
		logger.exception(new FileNotFoundException("some file was not found"));
		logger.info(getRandomString("in main logger"));

		Log log1 = logger.createLog("Log 1");
		log1.info(getRandomString("in test 1 log"));
		log1.warn(getRandomString("in test 1 log"));
		log1.exception(new ClassCastException("casting issues dude"));
		log1.info(getRandomString("in test 1 log"));
		
		Log log2 = logger.createLog("Log 2");
		log2.info(getRandomString("in test 2 log"));
		
		logger.info(getRandomString("in main logger"));
		log2.exception(new NullPointerException());

		Log log3 = logger.createLog("Log 3");
		log3.info(getRandomString("in test 3 log"));
		log3.warn(getRandomString("in test 3 log"));
		log3.warn(getRandomString("in test 3 log"));
		log3.info(getRandomString("in test 3 log"));
		
		log1.info(getRandomString("in test 1 log"));

		Log log4 = logger.createLog("Log 4");
		log4.info(getRandomString("in test 4 log"));
		log4.warn(getRandomString("in test 4 log"));
		log4.info(getRandomString("in test 4 log"));

		log1.warn(getRandomString("in test 1 log"));
		logger.warn(getRandomString("in main logger"));
		log4.warn(getRandomString("in test 4 log"));
		log3.warn(getRandomString("in test 3 log"));

	}
}
