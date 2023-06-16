package com.chimpcentral.tests;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.chimpcentral.logger.LResult;
import com.chimpcentral.logger.Log;
import com.chimpcentral.logger.Logger;
import com.chimpcentral.logger.LoggerOptions;

public class UpdatedLoggerTest {

	public static String userDir = System.getProperty("user.dir");
	public static String testResource = userDir + "/src/test/resources/com/chimpcentral";
	
	public static String getRandomString(String message) {
		return message + UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()
							+ UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()
							+ UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()
							+ UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()
							+ UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID();
	}
	
	public static String getRandomString(String message, int count) {
		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < count; i++) {
			sb.append(getRandomString(""));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		LoggerOptions loggerOptions = new LoggerOptions()
												.setFilename("mylogs.html")
												.setGithubURL("https://github.com/")
												.setJiraURL("https://www.atlassian.com/software/jira")
												.setMailToAddress("some@some.com")
												.setAzureRepoURL("https://azure.microsoft.com/en-us/")
												.setAgilityAiURL("https://digital.ai/products/agility/")
												.setTitle("My title")
												.setHeading("My Heading")
												.setSubHeading("my sub heading")
												.removeImages();
		
		Logger logger = new Logger(loggerOptions);
		logger.info(getRandomString("in main logger"));
		logger.info(getRandomString("in main logger"));
		logger.warn(getRandomString("in main logger"));
		logger.toNode("some-name", "message in main one");
		logger.toNode("some-name", "message in main two");
		logger.toNode("some-name", getRandomString("message in main three", 5));
		logger.exception(new FileNotFoundException("some file was not found"));
		logger.info(getRandomString("in main logger"));
		logger.image(testResource + "/digital-ai-1.png");
		logger.image(testResource + "/screenshot1.png");
		logger.image(testResource + "/screenshot1.png", 700);
		logger.image(testResource + "/screenshot1.png", 500);
		logger.image(testResource + "/screenshot1.png", 100);
		
		Log log1 = logger.createLog("Log 1");
		log1.info(getRandomString("in test 1 log"));
		log1.warn(getRandomString("in test 1 log"));
		log1.exception(new ClassCastException("casting issues dude"));
		log1.info(getRandomString("in test 1 log"));
		log1.image(testResource + "/digital-ai-1.png");
		log1.image(testResource + "/screenshot1.png");
		log1.image(testResource + "/screenshot1.png", 700);
		log1.image(testResource + "/screenshot1.png", 500);
		log1.image(testResource + "/screenshot1.png", 100);
		Log log2 = logger.createLog("Log 2");
		log2.info(getRandomString("in test 2 log"));
		
		logger.info(getRandomString("in main logger"));
		log2.exception(new NullPointerException());

		Log log3 = logger.createLog("Log 3");
		log3.info(getRandomString("in test 3 log"));
		log3.toNode("some-name", "message in log3 one");
		log3.toNode("some-name", "message in log3 two");
		log3.info(
				getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")
				+ getRandomString("lengthy").replaceAll("-", "")

				);
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
		
		List<Log> logs = new ArrayList<>();
		logs.add(logger);
		logs.add(log1);
		logs.add(log2);
		logs.add(log3);
		logs.add(log4);
		logs.forEach(e -> e.info("I have created this log"));
		log1.setResult(LResult.pass);
		log2.setResult(LResult.fail);
		log3.setResult(LResult.skip);
		
	}
}
