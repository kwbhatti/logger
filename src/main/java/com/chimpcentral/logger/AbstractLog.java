package com.chimpcentral.logger;

import java.util.ArrayList;
import java.util.List;

import com.chimpcentral.date.DateHelper;

/**
 * Default class to be extended only by Logger and Log.
 * <br>AbstractLog implements all the methods that are common for logging.
 *  AbstractLog class provides the following information about the log.
 *  <ul>
 *  <li>logFile (LogFile class): this the log file that all the information is 
 *   getting appended/updated to during runtime. The LogFile object is shared 
 *   between the Logger and all the Logs created.</li>
 *  <li>name (String): name of the log file where the Logger name is set to main-log</li>
 *  <li>logTableBodyId (String): is a string and is created in the constructor.
 *   Uses logTableBodyIds to make sure that the id does not exists other wise adds a 1 to the id</li>
 *  <li>logTableRowTag (String): each log link is related to a single table and the table 
 *   gets a row tag added based on the log name.</li>
 *  <li>hasTableBody (boolean): is created only once upon writing any information to the log table.
 *   Id the log table already exists then the log table is not created</li>
 *  <li>collapsibleIds (List of Strings): list of all the collapsible ids for the log.
 *   A new id is generated and a 1 is added to the id when ever toNode method is called</li>
 *  </ul>
 *  Responsible for performing all common actions like
 *   info, warning, exception, toNode and others.
 * @author kbhatti
 *
 */
abstract class AbstractLog {
	
	protected LogFile logFile = null;
	protected LogFileHelper logFileHelper = null;
	protected String name = null;
	protected String logTableBodyId = null;
	protected List<String> logTableBodyIds = new ArrayList<String>();
	protected String logTableRowTag = null;
	private boolean hasTableBody = false;
	protected List<String> collapsibleIds = new ArrayList<String>();
	
	/**
	 * Constructor only used by Logger and Log classes.
	 *  Sets the name of the log file, the log table body id, and the log table row tag.
	 * @param name String name of the log (is main-log for logger)
	 */
	AbstractLog(String name) {
		this.logFileHelper = new LogFileHelper();
		this.name = name;
		this.logTableBodyId = getLogTableId();
		this.logTableRowTag = "<!-- chimp-central-" + name + "-log-table-row -->";
	}
	
	/**
	 * Return the log file for the main log file to be manipulated.
	 * @return LogFile instance which is the main file being updated.
	 */
	abstract LogFile getLogFile();
	
	/**
	 * Common method used by internal methods to get ids for HTML Elements.
	 *  Takes a list of existing ids and returns an id with 1
	 *  at the end if the id does not exist in list otherwise keeps iterating
	 *  and keeps adding 1 to the finalId which then gets appended to the Element Id.
	 * @param baseId initial Element Id without the index of the id
	 * @param existingIds list of existing elements for similar elements
	 * @return String value of base Id after appending the index
	 */
	protected String getElementId(String baseId, List<String> existingIds) {
		String id = baseId;
		String finalId = null;
		int index = 0;
		do {
			finalId = id + String.valueOf(index);
			index++;
		} while (existingIds.contains(finalId));
		existingIds.add(finalId);
		return finalId;
	}
	
	/**
	 * Gets the log table Id by called getElemetId which handles similar elements
	 * @return String value of log table id
	 */
	protected String getLogTableId() {
		if (this.name.equals(Constants.mainlogId)) return this.name;
		else return getElementId(this.name + "-logs-", logTableBodyIds);
	}
	
	/**
	 * Returns name of the log which is set to main-logs for main log
	 * @return String value of the log name
	 */
	String getName() {
		return this.name;
	}

	/**
	 * Gets log table body HTML from LogFileHelper class.
	 *  Replaces the logTableRowTag value to the new value which includes the name of the log.
	 *  Replaces the logTableBodyIdTag value to the new value which includes the name and the index of the log.
	 *  If the log is for the main log then removes the style of display none, so that main log always shows upon load.
	 *  Calls the createTableBody for the main log file to create the table.
	 */
	private void createTableBody() {
		String tableBodyHTML = logFileHelper.getLogTableBodyHTML();
		tableBodyHTML = tableBodyHTML.replace(Tags.logTableRowTag, logTableRowTag);
		tableBodyHTML = tableBodyHTML.replace(Tags.logTableBodyIdTag, logTableBodyId);
		if (this.name.equals(Constants.mainlogId)) {
			tableBodyHTML = tableBodyHTML.replace(" style=\"display: none;\"", "");
		}
		getLogFile().createTableBody(tableBodyHTML);
		hasTableBody = true;
	}
	
	/**
	 * Returns the row based on the message.
	 *  Creates a row element and adds the following cells to it.
	 *  <ul>
	 *  <li>info/warning: warning is set to red color</li>
	 *  <li>time stamp with date and time</li>
	 *  <li>original message</li>
	 * 	</ul> 
	 * @param message String message to be logged
	 * @param isWarning boolean if the message should be logged as warning
	 * @return
	 */
	private <T> String getMessage(T message, boolean isWarning) {
		String timestamp = new DateHelper().getCurrentTimeStamp();
		StringBuilder messageBuilder = new StringBuilder()
				.append("<tr>");
		if (isWarning) messageBuilder.append("<td class=\"warning\">" + "warning" + "</td>");
		else messageBuilder.append("<td>" + "info" + "</td>");
		messageBuilder.append("<td>" + timestamp + "</td>")
				.append("<td>" + message + "</td>")
				.append("</tr>")
				.append(this.logTableRowTag);
		return messageBuilder.toString();
	}
	
	/**
	 * Public method to log information to the log
	 * @param message String message to be logged
	 */
	public <T> void info(T message) {
		if (!hasTableBody) createTableBody();
		getLogFile().log(this.logTableRowTag, getMessage(message, false));
	}
	
	/**
	 * Public method to log warning.
	 *  The warning text itself is logged in red color.
	 * @param message String message to be logged
	 */
	public <T>void warn(T message) {
		if (!hasTableBody) createTableBody();
		getLogFile().log(this.logTableRowTag, getMessage(message, true));
	}
	
	/**
	 * Public method to log to an accordion looking element.
	 *  Suggested used when the message is too big. 
	 *  Some examples are data base query results.
	 *  Request and Response from an API call.
	 *  This would create 2 div elements, where the div with the name is displayed
	 *  and the div with the message is hidden. 
	 *  The second div will be displayed/not displayed upon clicking the first div	 *  
	 * @param name String name to be display for the node
	 * @param message String message for the node body
	 */
	public <T> void toNode(String name, T message) {
		String logCollapsibleId = getElementId(logTableBodyId + "-name", collapsibleIds);
		String collapsibleHTML = logFileHelper.getlogCollapsibleHTML();
		collapsibleHTML = collapsibleHTML.replace(Tags.logCollapsibleTopTextTag, name);
		collapsibleHTML = collapsibleHTML.replace(Tags.logCollapsibleBottomIdTag, logCollapsibleId);
		collapsibleHTML = collapsibleHTML.replace(Tags.logCollapsibleBottomTextTag, String.valueOf(message));
		info(collapsibleHTML);
	}
	
	/**
	 * Public method to log exceptions.
	 *  By default the exception is logged as a warning.
	 *  Logs the exception message, the cause, 
	 *  the exception class, and the stack trace.
	 * @param exception Exception to be logged.
	 */
	public void exception(Exception exception) {
		StringBuilder stackTrace = new StringBuilder();
		for (StackTraceElement trace: exception.getStackTrace()) {
			stackTrace.append(trace + "<br>");
		}
		StringBuilder exceptionMessage = new StringBuilder()
				.append("An exception was thrown")
				.append("<br>Exception Message: " + exception.getMessage())
				.append("<br>Exception Cause: " + exception.getCause())
				.append("<br>Exception Class Name: " + exception.getClass().getSimpleName())
				.append("<br>Exception StackTrace: <br>" + stackTrace.toString());
		warn(exceptionMessage.toString());
	}
}
