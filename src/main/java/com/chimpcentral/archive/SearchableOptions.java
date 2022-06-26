package com.chimpcentral.archive;

import java.util.Map;

interface SearchableOptions<T extends AbstractLoggerOptions<T>> {

	public String getUserOption(UserOption loggerOption);

	public Map<UserOption, String> getAllUserOptions();
	
	public AbstractLoggerOptions<T> setUserOption(UserOption userOption, String value);
	
	public String getTargetDir();
	
	public AbstractLoggerOptions<T> setTargetDir(String targetDir);
	
	public String getFilename();
	
	public AbstractLoggerOptions<T> setFilename(String filename);
	
	public String getFilepath();
	
	public String getTitle();
	
	public AbstractLoggerOptions<T> setTitle(String title);
	
	public String getHeading();
	
	public AbstractLoggerOptions<T> setHeading(String heading);
	
	public String getSubHeading();
	
	public AbstractLoggerOptions<T> setSubHeading(String subHeading);
}
