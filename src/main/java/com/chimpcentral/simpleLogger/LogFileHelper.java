package com.chimpcentral.simpleLogger;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;
import com.chimpcentral.simpleLogger.Constants.AdditionalLink;

class LogFileHelper {

	FlatFile getFile(String filepath) {
		try {
			return new FlatFile(filepath, FileStatus.EXISTING);
		} catch (IOException e) {
			System.out.println(filepath);
			e.printStackTrace();
		}
		return null;
	}
	
	String getBaseHTML() {
		String content = getFile(Filepaths.baseHTMLFilepath).getContent();
		return content;
	}
	
	String getLogoLinkHTML() {
		String content = getFile(Filepaths.logoLinkHTMLFilepath).getContent();
		return content;
	}
	
	String getMainlogTextLinkHTML() {
		String content = getFile(Filepaths.mainlogTextLinkHTMLFilepath).getContent();
		return content;
	}
	
	String getMainlogImageLinkHTML() {
		String content = getFile(Filepaths.mainlogImageLinkHTMLFilepath).getContent();
		content = content.replace(Tags.mainLogLinkSrcURLTag, Constants.mainlogImageSrcURL);
		return content;
	}
	
	String getAdditionalTextLinkHTML(AdditionalLink link, String href) {
		String content = getFile(Filepaths.additionalTextLinkHTMLFilepath).getContent();
		content = content.replace(Tags.additionalLinkHrefTag, href);
		content = content.replace(Tags.additionalLinkNameTag, link.value);
		return content;
	}
	
	String getAdditionalImageLinkHTML(AdditionalLink link, String href) {
		String content = getFile(Filepaths.additionalImageLinkHTMLFilepath).getContent();
		content = content.replace(Tags.additionalLinkHrefTag, href);
		content = content.replace(Tags.additionalLinkSrcURLTag, link.srcURL);
		return content;
	}
	
	String getLoglistContainerHTML() {
		String content = getFile(Filepaths.loglistContainerHTMLFilepath).getContent();
		return content;
	}
	
	String getLogContainerWithoutLoglistHTML() {
		String content = getFile(Filepaths.logContainerWithoutLoglistHTMLFilepath).getContent();
		return content;
	}
	
	String getLogContainerWithLoglistHTML() {
		String content = getFile(Filepaths.logContainerWithLoglistHTMLFilepath).getContent();
		return content;
	}
	
	String getLogListItemHTML() {
		String content = getFile(Filepaths.loglistItemHTMLFilepath).getContent();
		return content;
	}
	
	String getLogTableBodyHTML() {
		String content = getFile(Filepaths.logTableBodyHTMLFilepath).getContent();
		return content;
	}
}
