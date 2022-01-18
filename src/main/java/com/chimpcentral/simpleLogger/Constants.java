package com.chimpcentral.simpleLogger;

public class Constants {

	static final String logoURL = "https://github.com/kwbhatti/logger/blob/master/src/main/resources/com/chimpcentral/logo-white.png?raw=true";
	static final String logoLink = "https://chimp-central.com/";
	static final String filename = "logs.html";
	static final String title = "CHIMP CENTRAL";
	static final String heading = "CHIMP CENTRAL";
	static final String subHeading = "PROJECT LOGS";
	
	static final String mainlogImageSrcURL = "https://github.com/kwbhatti/logger/blob/master/src/main/resources/com/chimpcentral/log-2.png?raw=true";
	
	enum AdditionalLink {
		GITHUB ("github", "https://github.com/kwbhatti/logger/blob/master/src/main/resources/com/chimpcentral/github-4.png?raw=true"),
		JIRA ("jira", "https://github.com/kwbhatti/logger/blob/master/src/main/resources/com/chimpcentral/jira-1.png?raw=true"),
		EMAIL ("email", "https://github.com/kwbhatti/logger/blob/master/src/main/resources/com/chimpcentral/email-1.png?raw=true");
		
		String value = null;
		String srcURL = null;
		
		private AdditionalLink(String value, String srcURL) {
			this.value = value;
			this.srcURL = srcURL;
		}
	}
}
