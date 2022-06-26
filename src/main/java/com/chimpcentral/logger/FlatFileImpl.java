package com.chimpcentral.logger;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;

/**
 * Default class that extends FlatFile from Chimp Central and can not be used outside the project
 * <br>This class overwrites the existing methods in FlatFile by adding try catch blocks
 * <br>The allows the user not having to deal with these exceptions
 * <br>If an exception is thrown, the error message would print for the user for debugging
 * @author kbhatti
 *
 */
class FlatFileImpl extends com.chimpcentral.io.FlatFile {

	/**
	 * Default Constructor which sets the filepath, and the status for this filepath
	 * @param filepath Path to the file where this file needs to be created or exists
	 * @param fileStatus Status for the file if it is a NEW file being created, an EXISTING file, for NA does not check the status
	 * @throws IOException exception thrown in case of file not found
	 */
	FlatFileImpl(String filepath, FileStatus fileStatus) throws IOException {
		super(filepath, fileStatus);
	}
	
	/**
	 * Appends content to the file (has to be public because of super class)
	 * <br>Takes String parameter that would get written to the file
	 * <br>Wraps the super class method by surrounding with a try catch block
	 */
	@Override
	public FlatFileImpl appendContent(String content) {
		try {
			super.appendContent(content);
		} catch (IOException e) {
			System.err.println(Constants.errorStartMessage);
			System.err.println("Could not append content, this is an internal issue with chimp cental logger");
			System.err.println(Constants.errorEmailMessage);
			e.printStackTrace();
			System.err.println(Constants.errorEndMessage);
		}
		return this;
	}
	
	/**
	 * Reads content from the file and returns as a String (has to be public because of super class)
	 * <br>Wraps the super class method by surrounding with a try catch block
	 */
	@Override
	public String getContent() {
		try {
			return super.getContent();
		} catch (IOException e) {
			System.err.println(Constants.errorStartMessage);
			System.err.println("Could not get content, this is an internal issue with chimp cental logger");
			System.err.println(Constants.errorEmailMessage);
			e.printStackTrace();
			System.err.println(Constants.errorEndMessage);
		}
		return null;
	}
	
	/**
	 * Replaces a sub string of existing content with new content
	 * <br>Saves existing content to a string variable
	 * <br>Clears content in the file
	 * <br>Appends content after replacing the oldString with the newString in the saved variable to the file
	 * @param oldString sub-string that needs to be replaced in the file
	 * @param newString sub-string that oldString needs to be replaced with in the file
	 * @return returns this class after modifying the content in this FlatFile
	 */
	FlatFileImpl replaceContent(String oldString, String newString) {
		String existingContent = getContent();
		this.clearContent();
		this.appendContent(existingContent.replace(oldString, newString));
		return this;
	}
	
	/**
	 * Clears content in the file (has to be public because of super class)
	 * <br>Wraps the super class method by surrounding with a try catch block
	 */
	@Override
	public FlatFileImpl clearContent() {
		try {
			super.clearContent();
		} catch (IOException e) {
			System.err.println(Constants.errorStartMessage);
			System.err.println("Could not clear content, this is an internal issue with chimp cental logger");
			System.err.println(Constants.errorEmailMessage);
			e.printStackTrace();
			System.err.println(Constants.errorEndMessage);
		}
		return this;
	}
}
