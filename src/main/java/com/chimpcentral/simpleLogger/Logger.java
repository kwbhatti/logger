package com.chimpcentral.simpleLogger;

public class Logger {

	private LoggerOptions loggerOptions = null;
	
	public Logger(LoggerOptions loggerOptions) {
		this.loggerOptions = loggerOptions;
	}
	
	public Logger() {
		this(new LoggerOptions());
	}
	
	public LoggerOptions getLoggerOptions() {
		return this.loggerOptions;
	}
	
	public Log createLog(String name) {
		return new Log(name);
	}
	
}
