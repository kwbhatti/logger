package com.chimpcentral.archive;

class Logger {

	private LoggerInfo loggerInfo = null;
	public MainLog mainLog = null;
	
	public Logger() {
		this.loggerInfo = new LoggerInfo();
	}
	
	public Logger(SearchableOptions<UserOptions> userOptions) {
		this.loggerInfo = new LoggerInfo(userOptions);
	}
	
	public LoggerInfo getLoggerInfo() {
		return this.loggerInfo;
	}
	
	public Log createLog() {
		mainLog = new MainLog();
		return mainLog;
	}
	
	public Log getMainLog() {
		return this.mainLog;
	}
	
	public void flush() {
		Compiler compiler = new Compiler(this);
		compiler.compile();
	}
}
