package com.chimpcentral.logger;

/**
 * LoggerOptions is a public class 
 *  and allows the user to overwrite default logger properties.
 *  Sets the default logger properties, some of which are then overwritten by user.
 * <br>The user can overwrite the following properties.
 * <ul>
 * <li>targetDir: Directory to create the log file which defaults to Project directory target folder</li>
 * <li>filename: Name of the log file to be created which defaults to logs.html</li>
 * <li>logoSrcURL: Source URL for the logo which defaults to Chimp Central logo</li>
 * <li>title: Title of the log file which defaults to CHIMP CENTRAL</li>
 * <li>heading: Heading of the log file which defaults to CHIMP CENTRAL</li>
 * <li>subHeading: Sub Heading of the log file which defaults to Project Logs</li>
 * </ul>
 * <br>Also allows the user to add some links to the log file.
 *  These links are not in the log file by default and are only created once the links are provided
 *  using setter methods.
 * <ul>
 * <li>githubURL: URL to user's GitHub site</li>
 * <li>jiraURL: URL to user's Jira site</li>
 * <li>mailToAddress: email address for user</li>
 * </ul>
 * <br>Additionally the user can call removeImages method
 *  to replace all the icons/images to text. 
 *  Does not make a significant difference in page load
 *  and is only available in case the user can not access the icons
 *  or the user does not want the icons for any other reason.
 * @author kbhatti
 *
 */
public class LoggerOptions {
	
	private String targetDir = null;
	private String filename = null;
	private String filepath = null;
	private String logoSrcURL = null;
	private String logoLinkURL = null;
	private String githubURL = null;
	private String jiraURL = null;
	private String agilityAiURL = null;
	private String azureRepoURL = null;
	private String mailToAddress = null;
	private String title = null;
	private String heading = null;
	private String subHeading = null;
	private boolean removeImagesState = false;
	
	/**
	 * Public constructor to initialize the LoggerOptions class
	 * Sets the default logger property values
	 */
	public LoggerOptions() {
		setDefaultValues();
	}
	
	/**
	 * Sets the default values and is called by the constructor
	 * Get the default values from Constants class and uses the static final variables.
	 */
	private void setDefaultValues() {
		setTargetDir(Constants.targetDir);
		setLogoSrcURL(Constants.logoSrcURL);
		setLogoLinkURL(Constants.logoLink);
		setFilename(Constants.filename);
		setTitle(Constants.title);
		setHeading(Constants.heading);
		setSubHeading(Constants.subHeading);
	}
	
	/**
	 * Returns target directory
	 * @return String value of target directory
	 */
	String getTargetDir() {
		return targetDir;
	}
	
	/**
	 * Sets the target directory where the log file will be created
	 * @param targetDir String: target folder location
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setTargetDir(String targetDir) {
		this.targetDir = targetDir;
		return this;
	}
	
	/**
	 * Returns log file name
	 * @return String value of the log file name
	 */
	String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the log file name 
	 * @param filename String: log file name
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setFilename(String filename) {
		this.filename = filename;
		setFilepath();
		return this;
	}
	
	/**
	 * Returns log absolute log file path
	 * @return String value of log file path
	 */
	public String getFilepath() {
		return filepath;
	}
	
	/**
	 * Sets the log file path by Logger Options (private)
	 * @return instance of the LoggerOptions
	 */
	private LoggerOptions setFilepath() {
		this.filepath = getTargetDir() + System.getProperty("file.separator") + getFilename();
		return this;
	}
	
	/**
	 * Returns logo source URL
	 * @return String value of logo source URL
	 */
	String getLogoSrcURL() {
		return this.logoSrcURL;
	}
	
	/**
	 * Sets the logo source URL to be displayed in the log file
	 * @param srcURL String: logo source URL
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setLogoSrcURL(String srcURL) {
		this.logoSrcURL = srcURL;
		this.logoLinkURL = "";
		return this;
	}
	
	/**
	 * Returns logo link (href tag) URL
	 * @return String value of logo link (href tag) URL
	 */
	String getLogoLinkURL() {
		return this.logoLinkURL;
	}
	
	/**
	 * Sets the logo link (href tag) URL, which is only set if Chimp Central is used.
	 *  Does not allow user to add href tag to their logo
	 * @param href String: logo link (href tag) URL
	 * @return instance of the LoggerOptions
	 */
	LoggerOptions setLogoLinkURL(String href) {
		this.logoLinkURL = href;
		return this;
	}
	
	/**
	 * Returns GitHub URL (href tag)
	 * @return String value of GitHub URL (href tag)
	 */
	String getGithubURL() {
		return githubURL;
	}

	/**
	 * Sets the GitHub link URL (href tag)
	 * @param href String: GitHib URL (href tag)
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setGithubURL(String href) {
		this.githubURL = href;
		return this;
	}

	/**
	 * Returns Jira URL (href tag)
	 * @return String value of Jira URL (href tag)
	 */
	String getJiraURL() {
		return jiraURL;
	}

	/**
	 * Sets the Jira link URL (href tag)
	 * @param href String: Jira URL (href tag)
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setJiraURL(String href) {
		this.jiraURL = href;
		return this;
	}

	/**
	 * Sets the Azure Repo link URL (href tag)
	 * @param href String: Azure Repo URL (href tag)
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setAzureRepoURL(String href) {
		this.azureRepoURL = href;
		return this;
	}
	
	/**
	 * Returns Azure Repo URL (href tag)
	 * @return String value of Azure Repo (href tag)
	 */
	String getAzureRepoURL() {
		return azureRepoURL;
	}

	/**
	 * Sets the Agility AI link URL (href tag)
	 * @param href String: Agility AI URL (href tag)
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setAgilityAiURL(String href) {
		this.agilityAiURL = href;
		return this;
	}
	
	/**
	 * Returns Agility AI URL (href tag)
	 * @return String value of Agility URL (href tag)
	 */
	String getAgilityAiURL() {
		return agilityAiURL;
	}
	
	/**
	 * Returns mail to address for mailing link
	 * @return String value of mail to address
	 */
	String getMailToAddress() {
		return mailToAddress;
	}

	/**
	 * Sets the mail-to-address for the mailing link
	 * @param mailToAddress String: mail to address
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setMailToAddress(String mailToAddress) {
		this.mailToAddress = "mailto: " + mailToAddress;
		return this;
	}
	
	/**
	 * Returns log title
	 * @return String value of log title
	 */
	String getTitle() {
		return title;
	}
	
	/**
	 * Sets the value of log title
	 * @param title String: log title
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setTitle(String title) {
		this.title = title;
		return this;
	}
	
	/**
	 * Returns log heading
	 * @return String value of log heading
	 */
	String getHeading() {
		return heading;
	}
	
	/**
	 * Sets the value of log heading
	 * @param heading String: log heading
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setHeading(String heading) {
		this.heading = heading;
		return this;
	}
	
	/**
	 * Returns log sub-heading
	 * @return String value of log sub-heading
	 */
	String getSubHeading() {
		return subHeading;
	}
	
	/**
	 * Sets the value of log sub-heading
	 * @param subHeading String: log sub-heading
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions setSubHeading(String subHeading) {
		this.subHeading = subHeading;
		return this;
	}
	
	/**
	 * Returns the boolean value of removeImagesState.
	 *  Value is set to true upon user calling removeImages method.
	 * @return boolean value of remove images state
	 */
	boolean getRemoveImagesState() {
		return this.removeImagesState;
	}
	
	/**
	 * Allows the user to remove images from the log file.
	 *  The images include but are not limited to:
	 *  main log image, GitHub image, Jira image, email image.
	 *  Removing images does not have a high impact on performance.
	 * @return instance of the LoggerOptions
	 */
	public LoggerOptions removeImages() {
		this.removeImagesState = true;
		return this;
	}
	
}
