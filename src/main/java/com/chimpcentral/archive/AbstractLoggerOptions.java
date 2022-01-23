package com.chimpcentral.archive;

import java.util.HashMap;
import java.util.Map;

public class AbstractLoggerOptions<T> {
	
	protected Map<UserOption, String> userOptionsMap = new HashMap<UserOption, String>();
	protected String targetDir = null;
	protected String filename = null;
	protected String filepath = null;
	protected String title = null;
	protected String heading = null;
	protected String subHeading = null;
	
	@SuppressWarnings("unchecked")
	private T returnT(AbstractLoggerOptions<T> abstractLoggerOptions) {
		return (T) this;
	}
	
	public String getUserOption(UserOption userOption) {
		return this.userOptionsMap.get(userOption);
	}
	
	public Map<UserOption, String> getAllUserOptions() {
		return this.userOptionsMap;
	}
	
	public T setUserOption(UserOption userOption, String value) {
		switch (userOption) {
		case TARGET_DIR:
			setTargetDir(value);
			break;
		case FILE_NAME:
			setFilename(value);
			break;
		case TITLE:
			setTitle(value);
			break;
		case HEADING:
			setHeading(value);
			break;
		case SUB_HEADING:
			setSubHeading(value);
			break;
		}
		return returnT(this);
	}
	
	public String getTargetDir() {
		return this.targetDir;
	}
	
	public T setTargetDir(String targetDir) {
		this.targetDir = targetDir;
		this.userOptionsMap.put(UserOption.TARGET_DIR, targetDir);
		return returnT(this);
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	public T setFilename(String filename) {
		this.filename = filename;
		this.userOptionsMap.put(UserOption.FILE_NAME, filename);
		return returnT(this);
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public T setTitle(String title) {
		this.title = title;
		this.userOptionsMap.put(UserOption.TITLE, title);
		return returnT(this);
	}
	
	public String getHeading() {
		return this.heading;
	}
	
	public T setHeading(String heading) {
		this.heading = heading;
		this.userOptionsMap.put(UserOption.HEADING, heading);
		return returnT(this);
	}
	
	public String getSubHeading() {
		return this.subHeading;
	}
	
	public T setSubHeading(String subHeading) {
		this.subHeading = subHeading;
		this.userOptionsMap.put(UserOption.SUB_HEADING, subHeading);
		return returnT(this);
	}
}
