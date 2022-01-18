package com.chimpcentral.simpleLogger;

public class LoggerOptions {
	
	private String targetDir = null;
	private String filename = null;
	private String filepath = null;
	private String logoSrcURL = null;
	private String logoLinkURL = null;
	private String githubURL = null;
	private String jiraURL = null;
	private String mailToAddress = null;
	private String title = null;
	private String heading = null;
	private String subHeading = null;
	private boolean removeImagesState = false;
	
	public LoggerOptions(String targetDir) {
		setTargetDir(targetDir);
		setDefaultValues();
	}
	
	public LoggerOptions() {
		this(Filepaths.userDir + "/target");
	}
	
	private void setDefaultValues() {
		setLogoSrcURL(Constants.logoURL);
		setLogoLinkURL(Constants.logoLink);
		setFilename(Constants.filename);
		setTitle(Constants.title);
		setHeading(Constants.heading);
		setSubHeading(Constants.subHeading);
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
	
	public String getLogoSrcURL() {
		return this.logoSrcURL;
	}
	
	public LoggerOptions setLogoSrcURL(String srcURL) {
		this.logoSrcURL = srcURL;
		this.logoLinkURL = "";
		return this;
	}
	
	String getLogoLinkURL() {
		return this.logoLinkURL;
	}
	
	LoggerOptions setLogoLinkURL(String href) {
		this.logoLinkURL = href;
		return this;
	}
	
	public String getGithubURL() {
		return githubURL;
	}

	public LoggerOptions setGithubURL(String href) {
		this.githubURL = href;
		return this;
	}

	public String getJiraURL() {
		return jiraURL;
	}

	public LoggerOptions setJiraURL(String href) {
		this.jiraURL = href;
		return this;
	}

	public String getMailToAddress() {
		return mailToAddress;
	}

	public LoggerOptions setMailToAddress(String mailToAddress) {
		this.mailToAddress = "mailto: " + mailToAddress;
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
	
	public boolean getremoveImagesState() {
		return this.removeImagesState;
	}
	
	public LoggerOptions removeImages() {
		this.removeImagesState = true;
		return this;
	}
	
}
