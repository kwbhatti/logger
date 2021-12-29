package com.chimpcentral.logger;

import java.util.Arrays;

public class LoggerInfo extends AbstractLoggerOptions<LoggerInfo> implements SearchableOptions<LoggerInfo> {

	private static final String USER_DIR = System.getProperty("user.dir");
	private static final String RESOURCES_DIR = USER_DIR + "/src/main/resources/com/chimpcentral";

	public LoggerInfo() {
		setDefaultInfo();
	}
	
	public LoggerInfo(SearchableOptions<UserOptions> userOptions) {
		this();
		setLoggerOptions(userOptions);
	}
	
	public String getResourcesDir() {
		return RESOURCES_DIR;
	}
	
	private LoggerInfo setFilepath() {
		this.filepath = this.getTargetDir() + "/" + this.getFilename(); 
		return this;
	}
	
	private void setDefaultInfo() {
		this
			.setTargetDir(USER_DIR + "/target")
			.setFilename("logs.html")
			.setTitle("CHIMP CENTRAL")
			.setHeading("CHIMP CENTRAL")
			.setSubHeading("Execution Logs")
			.setFilepath();
	}
	
	private void setLoggerOptions(SearchableOptions<UserOptions> userOptions) {
		Arrays.asList(UserOption.values()).parallelStream().forEach(e -> {
			if (userOptions.getUserOption(e) != null) this.setUserOption(e, userOptions.getUserOption(e));
		});
		setFilepath();
	}
}
