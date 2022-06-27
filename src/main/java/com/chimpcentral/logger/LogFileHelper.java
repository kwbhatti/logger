package com.chimpcentral.logger;

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
	 * Return content from the base HTML file in resources folder
	 * @return base HTML as String
	 */
	synchronized String getBaseHTML() {
		return BaseHTMLContent.BASE_HTML;
	}
	
	/**
	 * Return content from the logo link HTML file in resources folder
	 * @return logo linkHTML as String
	 */
	synchronized String getLogoLinkHTML() {
		return BaseHTMLContent.LOGO_LINK;
	}
	
	/**
	 * Return content from the main log text link HTML file in resources folder
	 * @return main log text link HTML as String
	 */
	synchronized String getMainlogTextLinkHTML() {
		return BaseHTMLContent.MAIN_LOG_TEXT_LINK;
	}
	
	/**
	 * Return content from the main log image link HTML file in resources folder.
	 * Gets the file content and then replaces the value for main log image source URL.
	 * @return main log image link HTML as String
	 */
	synchronized String getMainlogImageLinkHTML() {
		String content = BaseHTMLContent.MAIN_LOG_IMAGE_LINK;
		content = content.replace(Tags.mainLogLinkSrcURLTag, Constants.mainLogImageSrcURL);
		return content;
	}
	
	/**
	 * Return content from the additional text link HTML file in resources folder.
	 * Gets the file content and then replaces the value for href and the text of the link.
	 * @return additional text link HTML as String
	 */
	synchronized String getAdditionalTextLinkHTML(AdditionalLink link, String href) {
		String content = BaseHTMLContent.ADDITIONAL_TEXT_LINK;
		content = content.replace(Tags.additionalLinkHrefTag, href);
		content = content.replace(Tags.additionalLinkNameTag, link.value);
		return content;
	}
	
	/**
	 * Return content from the additional image link HTML file in resources folder.
	 * Gets the file content and then replaces the value for href and the source URLs.
	 * @return additional image link HTML as String
	 */
	synchronized String getAdditionalImageLinkHTML(AdditionalLink link, String href) {
		String content = BaseHTMLContent.ADDITONAL_IMAGE_LINK;
		content = content.replace(Tags.additionalLinkHrefTag, href);
		content = content.replace(Tags.additionalLinkSrcURLTag, link.srcURL);
		return content;
	}
	
	/**
	 * Return content from the log list container HTML file in resources folder
	 * @return log list container HTML as String
	 */
	synchronized String getLoglistContainerHTML() {
		return BaseHTMLContent.LOG_LIST_CONTAINER_HTML;
	}
	
	/**
	 * Return content from the log container without log list HTML file in resources folder
	 * @return log container without log list HTML as String
	 */
	synchronized String getLogContainerWithoutLoglistHTML() {
		return BaseHTMLContent.LOG_CONTAINER_WITHOUT_LOG_LIST_HTML;
	}
	
	/**
	 * Return content from the log container with log list HTML file in resources folder
	 * @return log container with log list HTML as String
	 */
	synchronized String getLogContainerWithLoglistHTML() {
		return BaseHTMLContent.LOG_CONTAINER_WITH_LOGLIST_HTML;
	}
	
	/**
	 * Return content from the log list item HTML file in resources folder
	 * @return log list item HTML as String
	 */
	synchronized String getLogListItemHTML() {
		return BaseHTMLContent.LOG_LIST_ITEM_HTML;
	}
	
	/**
	 * Return content from the log table body HTML file in resources folder
	 * @return log table body HTML as String
	 */
	synchronized String getLogTableBodyHTML() {
		return BaseHTMLContent.LOG_TABLE_BODY_HTML;
	}
	
	/**
	 * Return content from the log collapsible HTML file in resources folder
	 * @return log collapsible HTML as String
	 */
	synchronized String getlogCollapsibleHTML() {
		return BaseHTMLContent.LOG_COLLAPSIBLE_HTML;
	}
}
