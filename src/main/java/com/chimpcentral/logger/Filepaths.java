package com.chimpcentral.logger;

/**
 * Constant File Paths used by the project
 * These paths define files that contain default HTML code
 * @author kbhatti
 *
 */
class Filepaths {

	/*
	 * Path to user directory
	 * Path to the resources folder for logger
	 * Path to base HTML file
	 */
	static final String userDir = System.getProperty("user.dir");
	static final String resourceDir = userDir + "/src/main/resources/com/chimpcentral/logger";
	static final String baseHTMLFilepath = resourceDir + "/baseHTML.html";
	
	/*
	 * Path to Base directory for navigation pane items
	 */
	static final String navigationDir = resourceDir + "/navigation";
	/*
	 * Path for HTML for the logo in the navigation pane
	 */
	static final String logoLinkHTMLFilepath = navigationDir + "/logoLink.html";
	/*
	 * Path for the HTML for main log without icon in the navigation pane  
	 */
	static final String mainlogTextLinkHTMLFilepath = navigationDir + "/mainlogTextLink.html";
	/*
	 * Path for the HTML for main log with icon in the navigation pane  
	 */
	static final String mainlogImageLinkHTMLFilepath = navigationDir + "/mainlogImageLink.html";
	/*
	 * Path for the HTML for additional links without icon in the navigation pane  
	 */
	static final String additionalTextLinkHTMLFilepath = navigationDir + "/additionalTextLink.html";
	/*
	 * Path for the HTML for additional links with icon in the navigation pane  
	 */
	static final String additionalImageLinkHTMLFilepath = navigationDir + "/additionalImageLink.html";
	/*
	 * Path to Base directory for list pane items in the middle
	 */
	static final String loglistDir = resourceDir + "/loglist";
	/*
	 * Path for the HTML for the main container for the list pane
	 */
	static final String loglistContainerHTMLFilepath = loglistDir + "/loglistContainerHTML.html";
	/*
	 * Path for the HTML for a single item in the list pane
	 */
	static final String loglistItemHTMLFilepath = loglistDir + "/loglistItemHTML.html";
	/*
	 * Path to Base directory for logs pane items on the left
	 */
	static final String logDir = resourceDir + "/log";
	/*
	 * Path for the HTML for the main logs container where there is not log list
	 * This would happen if the logger never gets a new log created for it
	 * This would make the main log container expand and the list pane would not show
	 */
	static final String logContainerWithoutLoglistHTMLFilepath = logDir + "/logContainerWithoutLoglistHTML.html";
	/*
	 * Path for the HTML for the main logs container where there is a log list
	 * This would happen if the logger gets a new log created inside of it by using Log log = logger.createLog();
	 * This would make the main log container smaller to provide room for the list pane in the middle
	 */
	static final String logContainerWithLoglistHTMLFilepath = logDir + "/logContainerWithLoglistHTML.html";
	/*
	 * Path for the HTML for the Table in the main log container
	 */
	static final String logTableBodyHTMLFilepath = logDir + "/logTableBodyHTML.html";
	/*
	 * Path for the HTML for the collapsible in the main log
	 * Collapsible has 2 containers where one is disabled and would be availabe upon clicking the top container
	 */
	static final String logCollapsibleHTMLFilepath = logDir + "/logCollapsibleHTML.html";
}
