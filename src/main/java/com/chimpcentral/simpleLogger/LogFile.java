package com.chimpcentral.simpleLogger;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;
import com.chimpcentral.simpleLogger.Constants.AdditionalLink;

class LogFile extends FlatFile {

	LoggerOptions loggerOptions = null;
	LogFileHelper logFileHelper = null;
	boolean isLoglistPresent = false;
	
	public LogFile(LoggerOptions loggerOptions) throws IOException {
		super(loggerOptions.getFilepath(), FileStatus.NEW);
		this.loggerOptions = loggerOptions;
		this.logFileHelper = new LogFileHelper();
		addBaseHTML();
	}
	
	private String getLogoLinkHTML() {
		String logoLinkHTML = logFileHelper.getLogoLinkHTML();
		logoLinkHTML = logoLinkHTML.replace(Tags.logoLinkHrefTag, loggerOptions.getLogoLinkURL());
		logoLinkHTML = logoLinkHTML.replace(Tags.logoLinkSrcURLTag, loggerOptions.getLogoSrcURL());
		return logoLinkHTML;
	}
	
	private String getMainlogLinkHTML() {
		if (loggerOptions.getremoveImagesState()) return logFileHelper.getMainlogTextLinkHTML();
		else return logFileHelper.getMainlogImageLinkHTML();
	}
	
	private String getAdditionalLinkHTML(AdditionalLink link, String href) {
		if (href == null) return "";
		else if (loggerOptions.getremoveImagesState()) return logFileHelper.getAdditionalTextLinkHTML(link, href);
			else return logFileHelper.getAdditionalImageLinkHTML(link, href);
	}
	
	private String getAdditionalLinksHTML() {
		return new StringBuilder()
				.append(getAdditionalLinkHTML(AdditionalLink.GITHUB, loggerOptions.getGithubURL()))
				.append(getAdditionalLinkHTML(AdditionalLink.JIRA, loggerOptions.getJiraURL()))
				.append(getAdditionalLinkHTML(AdditionalLink.EMAIL, loggerOptions.getMailToAddress()))
				.toString();
	}
	
	private void addBaseHTML() {
		String baseHTML = logFileHelper.getBaseHTML();
		baseHTML = baseHTML.replace(Tags.titleTag, loggerOptions.getTitle());
		baseHTML = baseHTML.replace(Tags.headingTag, loggerOptions.getHeading());
		baseHTML = baseHTML.replace(Tags.subHeadingTag, loggerOptions.getSubHeading());
		baseHTML = baseHTML.replace(Tags.logoLinkTag, getLogoLinkHTML());
		baseHTML = baseHTML.replace(Tags.mainLogLinkTag, getMainlogLinkHTML());
		baseHTML = baseHTML.replace(Tags.additionalLinksTag, getAdditionalLinksHTML());
		this.appendContent(baseHTML);
	}
	
	void createLoglist() {
		String loglistContainer = logFileHelper.getLoglistContainerHTML();
		this.replaceContent(Tags.logListTag, loglistContainer);
		this.replaceContent(logFileHelper.getLogContainerWithoutLoglistHTML(), logFileHelper.getLogContainerWithLoglistHTML());
		isLoglistPresent = true;
	}
	
	void createLogListItem(String name) {
		if (!isLoglistPresent) createLoglist();
		String logListItemHTML = logFileHelper.getLogListItemHTML();
		logListItemHTML = logListItemHTML.replace(Tags.logListItemNameTag, name);
		this.replaceContent(Tags.logListItemTag, logListItemHTML);
	}
	
	void createTableBody(String tableBodyHTML) {
		System.out.println(tableBodyHTML);
		this.replaceContent(Tags.logTableBodyTag, tableBodyHTML);
	}
	
	void log(String logTableRowTag, String content) {
		this.replaceContent(logTableRowTag, content);
	}
}
