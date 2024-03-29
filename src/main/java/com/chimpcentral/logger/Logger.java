package com.chimpcentral.logger;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;
import com.chimpcentral.io.FlatFile;

/**
 * Logger is the main class to create the log.
 * <br>Extends Log class and provides all the logging functionality.
 * <br>Logger must have LoggerOptions and LogFile
 * <br>Uses user provided logger options or uses default logger options.
 * <br>Creates a LogFile instance which in return creates the log file
 * @author kbhatti
 *
 */
public class Logger extends Log {

	LoggerOptions loggerOptions = null;
	
	/**
	 * Allows the user to provide logger options via LoggerOptions class instance.
	 *  Sets the name of the log to main-logs.
	 *  Creates base HTML file.
	 * @param loggerOptions LoggerOptions class instance which provides
	 *  the user capability to overwrite multiple default values.
	 */
	public Logger(LoggerOptions loggerOptions) {
		super(Constants.mainlogId);
		this.loggerOptions = loggerOptions;
		createBaseHTMLFile();
	}
	
	/**
	 * Does not takes the logger options and uses default logger options.
	 *  Recommended to use Logger with User provided logger options
	 *  to make the log file more personalized.
	 *  Sets the name of the log to main-logs.
	 *  Creates base HTML file. 
	 */
	public Logger() {
		this(new LoggerOptions());
	}
	
	/**
	 * Returns logger options for the class instance.
	 * @return LoggerOptions for the log file.
	 */
	LoggerOptions getLoggerOptions() {
		return this.loggerOptions;
	}
	
	/**
	 * Returns LogFile class instance for the main log.
	 */
	@Override
	LogFile getLogFile() {
		return this.logFile;
	}
	
	private void deleteExistingLogFile() throws IOException {
		if (new FlatFile(loggerOptions.getFilepath(), FileStatus.NA).exists()) 
			new FlatFile(loggerOptions.getFilepath(), FileStatus.EXISTING).delete();
	}
	
	/**
	 * Creates new instance of the LogFile class with Logger Options.
	 *  If an IOException is thrown notifies the user by logging 
	 *  information about the exception.
	 */
	private void createBaseHTMLFile() {
		try {
			deleteExistingLogFile();
			logFile = new LogFile(loggerOptions);
		} catch (IOException e) {
			System.err.println(Constants.errorStartMessage);
			System.err.println("Could not create log file. Make sure that the file does not already exist. Otherwise: ");
			System.err.println(Constants.errorEmailMessage);
			System.err.println(Constants.errorEndMessage);
		}
	}
	
	/**
	 * Creates a log inside the main logger.
	 *  When called for the first time, the create log
	 *  would create a log list and the main log can be
	 *  accessed from the main log text/image.
	 *  One logger can have as many logs as the user wants.
	 * @param name String name of the log file
	 * @return Instance of the Log class.
	 */
	public synchronized LogNode createLog(String name) {
		return new LogNode(this.logFile, name);
	}

	
	
}
