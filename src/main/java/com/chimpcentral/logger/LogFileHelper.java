package com.chimpcentral.logger;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;
import com.chimpcentral.logger.Constants.AdditionalLink;

/**
 * This class can not be extended and is only used internally by the project
 * <br>LogFileHelper class reads content from the HTML files in the resource directory.
 *  It mostly just return the HTML without any modifications.
 *  But in some instances does update the HTML before return the content of the HTML.
 * @author kbhatti
 *
 */
final class LogFileHelper {

	/**
	 * Handles exception when creating new instance of FlatFile.
	 * <br>Wraps the new FlatFile(filepath, filestatus)
	 *  and is only used by internal methods to read the existing files.
	 * @param Filepath Path for the file to be created FlatFile instance of
	 * @return Return FlatFile object. Returns null if the file is not found.
	 */
	private FlatFile getFile(String filepath) {
		try {
			return new FlatFile(filepath, FileStatus.EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Return content from the base HTML file in resources folder
	 * @return base HTML as String
	 */
	String getBaseHTML() {
		String content = getFile(Filepaths.baseHTMLFilepath).getContent();
		return content;
	}
	
	/**
	 * Return content from the logo link HTML file in resources folder
	 * @return logo linkHTML as String
	 */
	String getLogoLinkHTML() {
		String content = getFile(Filepaths.logoLinkHTMLFilepath).getContent();
		return content;
	}
	
	/**
	 * Return content from the main log text link HTML file in resources folder
	 * @return main log text link HTML as String
	 */
	String getMainlogTextLinkHTML() {
		String content = getFile(Filepaths.mainlogTextLinkHTMLFilepath).getContent();
		return content;
	}
	
	/**
	 * Return content from the main log image link HTML file in resources folder.
	 * Gets the file content and then replaces the value for main log image source URL.
	 * @return main log image link HTML as String
	 */
	String getMainlogImageLinkHTML() {
		String content = getFile(Filepaths.mainlogImageLinkHTMLFilepath).getContent();
		content = content.replace(Tags.mainLogLinkSrcURLTag, Constants.mainLogImageSrcURL);
		return content;
	}
	
	/**
	 * Return content from the additional text link HTML file in resources folder.
	 * Gets the file content and then replaces the value for href and the text of the link.
	 * @return additional text link HTML as String
	 */
	String getAdditionalTextLinkHTML(AdditionalLink link, String href) {
		String content = getFile(Filepaths.additionalTextLinkHTMLFilepath).getContent();
		content = content.replace(Tags.additionalLinkHrefTag, href);
		content = content.replace(Tags.additionalLinkNameTag, link.value);
		return content;
	}
	
	/**
	 * Return content from the additional image link HTML file in resources folder.
	 * Gets the file content and then replaces the value for href and the source URLs.
	 * @return additional image link HTML as String
	 */
	String getAdditionalImageLinkHTML(AdditionalLink link, String href) {
		String content = getFile(Filepaths.additionalImageLinkHTMLFilepath).getContent();
		content = content.replace(Tags.additionalLinkHrefTag, href);
		content = content.replace(Tags.additionalLinkSrcURLTag, link.srcURL);
		return content;
	}
	
	/**
	 * Return content from the log list container HTML file in resources folder
	 * @return log list container HTML as String
	 */
	String getLoglistContainerHTML() {
		String content = getFile(Filepaths.loglistContainerHTMLFilepath).getContent();
		return content;
	}
	
	/**
	 * Return content from the log container without log list HTML file in resources folder
	 * @return log container without log list HTML as String
	 */
	String getLogContainerWithoutLoglistHTML() {
		String content = getFile(Filepaths.logContainerWithoutLoglistHTMLFilepath).getContent();
		return content;
	}
	
	/**
	 * Return content from the log container with log list HTML file in resources folder
	 * @return log container with log list HTML as String
	 */
	String getLogContainerWithLoglistHTML() {
		String content = getFile(Filepaths.logContainerWithLoglistHTMLFilepath).getContent();
		return content;
	}
	
	/**
	 * Return content from the log list item HTML file in resources folder
	 * @return log list item HTML as String
	 */
	String getLogListItemHTML() {
		String content = getFile(Filepaths.loglistItemHTMLFilepath).getContent();
		return content;
	}
	
	/**
	 * Return content from the log table body HTML file in resources folder
	 * @return log table body HTML as String
	 */
	String getLogTableBodyHTML() {
		String content = getFile(Filepaths.logTableBodyHTMLFilepath).getContent();
		return content;
	}
	
	/**
	 * Return content from the log collapsible HTML file in resources folder
	 * @return log collapsible HTML as String
	 */
	String getlogCollapsibleHTML() {
		String content = getFile(Filepaths.logCollapsibleHTMLFilepath).getContent();
		return content;
	}
}
