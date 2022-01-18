package com.chimpcentral.simpleLogger;

public class Filepaths {

	static final String userDir = System.getProperty("user.dir");
	static final String resourceDir = userDir + "/src/main/resources/com/chimpcentral/simpleLogger";
	static final String baseHTMLFilepath = resourceDir + "/baseHTML.html";
	
	/*
	 * Navigation Pane Items
	 */
	static final String navigationDir = resourceDir + "/navigation";
	
	static final String logoLinkHTMLFilepath = navigationDir + "/logoLink.html";

	static final String mainlogTextLinkHTMLFilepath = navigationDir + "/mainlogTextLink.html";
	static final String mainlogImageLinkHTMLFilepath = navigationDir + "/mainlogImageLink.html";
	
	static final String additionalTextLinkHTMLFilepath = navigationDir + "/additionalTextLink.html";
	static final String additionalImageLinkHTMLFilepath = navigationDir + "/additionalImageLink.html";
	
	/*
	 * Log List Pane
	 */
	static final String loglistDir = resourceDir + "/loglist";
	static final String loglistContainerHTMLFilepath = loglistDir + "/loglistContainerHTML.html";
	static final String loglistItemHTMLFilepath = loglistDir + "/loglistItemHTML.html";
	
	/*
	 * Log Pane
	 */
	static final String logDir = resourceDir + "/log";
	static final String logContainerWithoutLoglistHTMLFilepath = logDir + "/logContainerWithoutLoglistHTML.html";
	static final String logContainerWithLoglistHTMLFilepath = logDir + "/logContainerWithLoglistHTML.html";
	static final String logTableBodyHTMLFilepath = logDir + "/logTableBodyHTML.html";
	
	
}
