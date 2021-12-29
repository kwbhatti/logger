package com.chimpcentral;

public class Logger {

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
	
	public static void main(String[] args) {
		UserOptions loggerOptions = new UserOptions()
											.setFilename("mytestlogs.html")
											.setTitle("MY TITLE")
											.setHeading("MY TEST HEADING")
											.setSubHeading("MY TEST SUB HEADING")
											.setTargetDir(System.getProperty("user.dir") + "/target");
		Logger logger = new Logger(loggerOptions);
		logger.loggerInfo.getAllUserOptions().entrySet().stream().forEach(System.out::println);
		String filepath = logger.loggerInfo.getFilepath();
		System.out.println(filepath);
		Log mainlog = logger.createLog();
		mainlog.info("i am in the main log message 1");
		mainlog.info("i am in the main log message 2");
		Log class1log = mainlog.createLog("Class 1 log");
		class1log.info("i am in class 1");
		Log class1test1log = class1log.createLog("Class 1 test 1 log");
		class1test1log.info("i am in class 1 test 1");
		Log class1test2log = class1log.createLog("Class 1 test 2 log");
		class1test2log.info("i am in class 1 test 2");
		Log class2log = mainlog.createLog("Class 2 log");
		class2log.info("i am in class 2");
		Log class2test1log = class2log.createLog("Class 2 test 1 log");
		class2test1log.info("i am in class 2 test 1");
		mainlog.info("i am in the main log message 3 after some time");
		Log class1test1param1log = class1test1log.createLog("Class 1 test 1 paramter 1 log");
		class1test1param1log.info("i am in class 1 test 1 param 1");
		class1log.info("i am another log in class 1 log");
		class2test1log.info("i am in class 2 test log 1");
		class1test2log.info("i am in class 1 test 2");
		logger.flush();
	}
}
