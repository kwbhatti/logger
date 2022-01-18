package com.chimpcentral.simpleLogger;

import java.io.IOException;

public class Logger extends Loggable {

	LoggerOptions loggerOptions = null;
	LogFile logFile = null;
	
	public Logger(LoggerOptions loggerOptions) {
		super("main");
		this.loggerOptions = loggerOptions;
		createBaseHTMLFile();
	}
	
	public Logger() {
		this(new LoggerOptions());
	}
	
	public LoggerOptions getLoggerOptions() {
		return this.loggerOptions;
	}
	
	LogFile getLogFile() {
		return this.logFile;
	}
	
	private void createBaseHTMLFile() {
		try {
			logFile = new LogFile(loggerOptions);
		} catch (IOException e) {
			System.out.println("**********LOGGER EXCEPTION START*********");
			System.out.println("Could not create logger");
			e.printStackTrace();
			System.out.println("**********LOGGER EXCEPTION END*********");
		}
	}
	
	public Log createLog(String name) {
		return new Log(this.logFile, name);
	}

	
	
}
