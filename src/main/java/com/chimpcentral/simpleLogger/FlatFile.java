package com.chimpcentral.simpleLogger;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;

public class FlatFile extends com.chimpcentral.io.FlatFile {

	public FlatFile(String filepath, FileStatus fileStatus) throws IOException {
		super(filepath, fileStatus);
	}
	
	public FlatFile appendContent(String content) {
		try {
			super.appendContent(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public String getContent() {
		try {
			return super.getContent();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public FlatFile replaceContent(String oldString, String newString) {
		String existingContent = getContent();
		this.clearContent();
		this.appendContent(existingContent.replace(oldString, newString));
		return this;
	}
	
	public FlatFile clearContent() {
		try {
			super.clearContent();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	
	
	
//	public static void main(String[] args) {
//		String value = "khurram waleed bhatti <start>is going to build<end> this log file and it is going to be fun";
//		
//		int startIndex = value.indexOf("<start>");
//		int endIndex = value.indexOf("<end>");
//		String stringToReplace = value.substring(startIndex, endIndex) + "<end>";
//		String newValue = value.replace(stringToReplace, "is a genius and have fun with");
//		System.out.println(newValue);
//		
//
//		
//	}

}
