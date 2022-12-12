package com.chimpcentral.logger;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;
import com.chimpcentral.logger.Constants.AdditionalLink;

/**
 * LogFile class can not be instantiated and extends the FlatFile within the project
 * This class provides the instance of the log file to be manipulated 
 * @author kbhatti
 *
 */
final class LogFile extends FlatFileImpl {
	
	LoggerOptions loggerOptions = null;
	LogFileHelper logFileHelper = null;
	boolean isLoglistPresent = false;
	
	/**
	 * Default constructor provides the log file path 
	 * and the status which is new to the super Flat File class
	 * <br>Sets the LoggerOptions (user + default) and a new instance of LogFileHelper class
	 * <br>Calls the addBaseHTML method which adds base HTML code in the log file
	 * @param loggerOptions LoggerOptions (user + default)
	 * @throws IOException exception thrown if file already exists
	 */
	LogFile(LoggerOptions loggerOptions) throws IOException {
		super(loggerOptions.getFilepath(), FileStatus.NEW);
		this.loggerOptions = loggerOptions;
		this.logFileHelper = new LogFileHelper();
		addBaseHTML();
	}
	
	/**
	 * Gets the HTML for logo link from the FileHelper class.
	 *  Replaces the href tag value to the value provided by LoggerOptions.
	 *  Replaces the src URL tag value to the value provided by LoggerOptions.
	 * @return updated String value for the logo link HTML
	 */
	private String getLogoLinkHTML() {
		String logoLinkHTML = logFileHelper.getLogoLinkHTML();
		logoLinkHTML = logoLinkHTML.replace(Tags.logoLinkHrefTag, loggerOptions.getLogoLinkURL());
		logoLinkHTML = logoLinkHTML.replace(Tags.logoLinkSrcURLTag, loggerOptions.getLogoSrcURL());
		return logoLinkHTML;
	}
	
	/**
	 * Gets the HTML for the main log link from the FileHelper class.
	 *  If user does not want images then returns the HTML which does not have images,
	 *  otherwise return the HTML which does have images.
	 * @return updated String value for the main log HTML
	 */
	private String getMainlogLinkHTML() {
		if (loggerOptions.getRemoveImagesState()) return logFileHelper.getMainlogTextLinkHTML();
		else return logFileHelper.getMainlogImageLinkHTML();
	}
	
	/**
	 * Handles getting HTML for the additional links in the navigation pane.
	 * <br>If the href parameter provided is null then return an empty string.
	 *  Otherwise checks in the LoggerOptions if the user wants images.
	 *  Returns the HTML without images for the additional links if the user does not want images.
	 *  And return the HTML with images for the additional links if the user does want images.
	 * @param link Enum for additional link that needs to be added.
	 *  User can only use links provided by the additional links.
	 * @param href Target link for the additional link
	 * @return updated String value for the additional link
	 */
	private String getAdditionalLinkHTML(AdditionalLink link, String href) {
		if (href == null) return "";
		else if (loggerOptions.getRemoveImagesState()) return logFileHelper.getAdditionalTextLinkHTML(link, href);
			else return logFileHelper.getAdditionalImageLinkHTML(link, href);
	}
	
	/**
	 * Handles getting HTML for all the additional links in the navigation pane.
	 * <br>Creates a string by calling getAdditionalLinkHTML method which handles a single link.
	 *  Goes over all the additional links available in the Additional Link Enum.
	 * @return updated String value for additional links
	 */
	private String getAdditionalLinksHTML() {
		return new StringBuilder()
				.append(getAdditionalLinkHTML(AdditionalLink.GITHUB, loggerOptions.getGithubURL()))
				.append(getAdditionalLinkHTML(AdditionalLink.JIRA, loggerOptions.getJiraURL()))
				.append(getAdditionalLinkHTML(AdditionalLink.AGILITY, loggerOptions.getAgilityAiURL()))
				.append(getAdditionalLinkHTML(AdditionalLink.AZURE, loggerOptions.getAzureRepoURL()))
				.append(getAdditionalLinkHTML(AdditionalLink.EMAIL, loggerOptions.getMailToAddress()))
				.toString();
	}
	
	/**
	 * Handles adding the Base HTML to the log file after the file is generated
	 * and this method is called by the class constructor.
	 * <br>Creates a String from the base HTML provided by the LogFileHelper class
	 *  and updates the following.
	 * <ul>
	 * <li>Tile</li>
	 * <li>Heading</li>
	 * <li>Sub Heading</li>
	 * <li>Logo image</li>
	 * <li>Main Log image/text</li>
	 * <li>Additional links image/text</li>
	 * </ul>
	 * Adds the updated String to the log file
	 */
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
	
	/**
	 * Handles creating the loglist in the log file.
	 *  This method is called by createLogListItem when if the log list does not already exist
	 * <br>Gets the log list container HTML from the LogFileHelper class.
	 *  Replaces the loglisttag in the HTML with the above String.
	 *  Replaces the main log container which does not support log list
	 *  to the main log container which does support the log list.
	 *  Sets the value of isLogListPreset to true.
	 */
	synchronized void createLoglist() {
		String loglistContainer = logFileHelper.getLoglistContainerHTML();
		this.replaceContent(Tags.logListTag, loglistContainer);
		this.replaceContent(logFileHelper.getLogContainerWithoutLoglistHTML(), logFileHelper.getLogContainerWithLoglistHTML());
		isLoglistPresent = true;
	}
	
	/**
	 * Creates the log list item in the log file.
	 * <br>Calls the createLogList method if the log list is not present in the log.
	 *  Gets the log list item HTML from LogFileHelper class.
	 *  First updates the HTML with the log table body id which links the item to the log in main logs.
	 *  Then updates the log list item name with the name of the log.
	 *  Then it replaces log list item tag in the exiting log with the new log list item
	 * @param name Name of the log being created.
	 * @param logTableBodyId id to link the list item to the main log table.
	 */
	synchronized void createLogListItem(String name, String logTableBodyId) {
		if (!isLoglistPresent) createLoglist();
		String logListItemHTML = logFileHelper.getLogListItemHTML();
		logListItemHTML = logListItemHTML.replace(Tags.logTableBodyIdTag, logTableBodyId);
		logListItemHTML = logListItemHTML.replace(Tags.logListItemNameTag, name);
		this.replaceContent(Tags.logListItemTag, logListItemHTML);
	}
	
	/**
	 * Replaces the log table body tag with the table body HTML
	 * @param tableBodyHTML HTML String for the table body
	 * <br>The String already contains the new log table body tag for recursion 
	 *  as well that table body id to link it to the list item.
	 */
	synchronized void createTableBody(String tableBodyHTML) {
		this.replaceContent(Tags.logTableBodyTag, tableBodyHTML);
	}
	
	/**
	 * Replaces the log table row tag with the log table row content
	 * @param logTableRowTag log table row tag.
	 * <br>The tag contains the updated tag with the name of the table
	 *  so the correct tag is updated for the respected log
	 * @param content row content for the table that already contains another log table row tag
	 */
	synchronized void log(String logTableRowTag, String content) {
		this.replaceContent(logTableRowTag, content);
	}
}
