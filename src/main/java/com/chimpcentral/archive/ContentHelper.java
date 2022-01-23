package com.chimpcentral.archive;

import java.io.IOException;

public class ContentHelper {

	private String resourcesDir = null;
	private static final String BASE_START_FILE_NAME = "baseStart.txt";
	private static final String BASE_END_FILE_NAME = "baseEnd.txt";
	private static final String MAIN_LOG_START_FILE_NAME = "mainLogStart.txt";
	private static final String MAIN_LOG_END_FILE_NAME = "mainLogEnd.txt";
	private static final String NODE_LOG_START_FILE_NAME = "nodeStart.txt";
	private static final String NODE_LOG_END_FILE_NAME = "nodeEnd.txt";
	
	
	public ContentHelper(String resourcesDir) {
		this.resourcesDir = resourcesDir;
	}
	
	private String getFileContent(String filename) {
		try {
			return new SourceFile(resourcesDir, filename).getContent();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getBaseStartFileContent() {
		return getFileContent(BASE_START_FILE_NAME);
	}
	
	public String getBaseEndFileContent() {
		return getFileContent(BASE_END_FILE_NAME);
	}
	
	public String getMainLogStartFileContent() {
		return getFileContent(MAIN_LOG_START_FILE_NAME);
	}
	
	public String getMainLogEndFileContent() {
		return getFileContent(MAIN_LOG_END_FILE_NAME);
	}
	
	public String getNodeLogStartFileContent() {
		return getFileContent(NODE_LOG_START_FILE_NAME);
	}
	
	public String getNodeLogEndFileContent() {
		return getFileContent(NODE_LOG_END_FILE_NAME);
	}
}
