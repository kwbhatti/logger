package com.chimpcentral.logger;

/**
 * Default Class which can not be used by external classes and can not be extended
 * <br>Common Constants used by the project to get static values for image URLs and default values
 * @author kbhatti
 *
 */
final class Constants {

	private Constants() {
	}
	
	static final String userDir = System.getProperty("user.dir");

	static final String GITHUB_SRC_URL = "https://raw.githubusercontent.com/kwbhatti/logger/master/src/main/resources/com/chimpcentral";
	/*
	 * Messages to print when an exception is thrown during execution (start/end)
	 */
	static final String errorStartMessage = "********** CHIMP CENTRAL EXCEPTION START *********";
	static final String errorEndMessage = "********** CHIMP CENTRAL EXCEPTION END *********";
	static final String errorEmailMessage = "Please notify to test-monkey@chimp-cental.com";

	/*
	 * Target Directory where the log file will be created
	 */
	static final String targetDir = userDir + "/target";
	/*
	 * Source URL for Chimp Central logo source which resides in the project
	 */
	static final String logoSrcURL = GITHUB_SRC_URL + "/logo-white.png";
	/*
	 * URL for Chimp Cental website
	 */
	static final String logoLink = "https://chimp-central.com/";
	/*
	 * Default Log file name
	 */
	static final String filename = "logs.html";
	/*
	 * Default Title of the browser tab
	 */
	static final String title = "CHIMP CENTRAL";
	/*
	 * Default main heading for the log file
	 */
	static final String heading = "CHIMP CENTRAL";
	/*
	 * Default sub heading for the log file
	 */
	static final String subHeading = "Project Logs";
	/*
	 * Source URL for main logs icon
	 */
	static final String mainLogImageSrcURL = GITHUB_SRC_URL + "/log-2.png";
	/*
	 * Name of the main logs 
	 * This name gets used for click function for main log button and for the main logs table id
	 */
	static final String mainlogId = "main-logs";
	/*
	 * Additional links which would be added upon users input
	 * GITHUB/JIRA/EMAIL
	 * value provides the default value of the Enums
	 * srcURL provies the Source URL for the icons
	 */
	enum AdditionalLink {
		GITHUB ("github", GITHUB_SRC_URL + "/github-4.png"),
		JIRA ("jira", GITHUB_SRC_URL + "/jira-1.png"),
		EMAIL ("email", GITHUB_SRC_URL + "/email-1.png"),
		AGILITY ("agility ai", GITHUB_SRC_URL + "/digital-ai-2.png"),
		AZURE ("azure", GITHUB_SRC_URL + "/azure-1.png");
		
		String value = null;
		String srcURL = null;
		
		/**
		 * Default constructor to set the values for default value and Source URL
		 * @param value
		 * @param srcURL
		 */
		private AdditionalLink(String value, String srcURL) {
			this.value = value;
			this.srcURL = srcURL;
		}
	}
}
