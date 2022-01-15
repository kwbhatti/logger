package com.chimpcentral.simpleLogger;

public class LoggerOptions {
	
	private String targetDir = null;
	private String filename = null;
	private String filepath = null;
	private String title = null;
	private String heading = null;
	private String subHeading = null;
	
	public LoggerOptions(String targetDir) {
		setTargetDir(targetDir);
		setDefaultValues();
	}
	
	LoggerOptions() {
		this(System.getProperty("user.dir") + "/target");
	}
	
	private void setDefaultValues() {
		setFilename("logs.html");
		setTitle("Project Logs");
		setHeading("Project Logs");
		setSubHeading("logs for the project");
	}
	
	public String getTargetDir() {
		return targetDir;
	}
	
	public LoggerOptions setTargetDir(String targetDir) {
		this.targetDir = targetDir;
		return this;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public LoggerOptions setFilename(String filename) {
		this.filename = filename;
		setFilepath();
		return this;
	}
	
	public String getFilepath() {
		return filepath;
	}
	
	private LoggerOptions setFilepath() {
		this.filepath = getTargetDir() + "/" + getFilename();
		return this;
	}
	
	public String getTitle() {
		return title;
	}
	
	public LoggerOptions setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getHeading() {
		return heading;
	}
	
	public LoggerOptions setHeading(String heading) {
		this.heading = heading;
		return this;
	}
	
	public String getSubHeading() {
		return subHeading;
	}
	
	public LoggerOptions setSubHeading(String subHeading) {
		this.subHeading = subHeading;
		return this;
	}
}
