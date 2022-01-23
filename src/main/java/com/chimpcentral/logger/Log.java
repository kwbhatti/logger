package com.chimpcentral.logger;

/**
 * Log is a public class and extends Abstract log.
 *  And provides all the logging methods to the user.
 * Provides the instance of a log file within the logger
 * and should be created after creating the logger by using the following code
 * <code>
 * Logger mylogger = new Logger();
 * Log log1 = mylogger.createLog("some name for log");
 * </code>
 * <br>Log is a sub-set of the main logger.
 * Creating a new log for the first time would create a log list pane along with the log item.
 * Otherwise it would only create a log list item
 * The log list item has a link that points to the respective log table in the main logs pane
 */
public class Log extends AbstractLog {
	
	/**
	 * Default constructor that gets called by the logger instance 
	 * The logger instance is responsible for passing the LogFile class object to the constructor
	 * along with the name of the log provided by the user.
	 * @param logFile LogFile which extends the FlatFile where the content is being written to
	 * @param name Name of the log to be created in the logger
	 */
	Log(LogFile logFile, String name) {
		super(name);
		this.logFile = logFile;
		this.logFile.createLogListItem(name, logTableBodyId);
	}

	@Override
	LogFile getLogFile() {
		return this.logFile;
	}
	
}
