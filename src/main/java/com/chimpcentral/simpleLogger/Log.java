package com.chimpcentral.simpleLogger;

public class Log extends Loggable {
		
	public Log(LogFile logFile, String name) {
		super(name);
		this.logFile = logFile;
		this.logFile.createLogListItem(name);
	}

	@Override
	LogFile getLogFile() {
		return this.logFile;
	}
	
}
