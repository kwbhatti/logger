package com.chimpcentral.simpleLogger;

import com.chimpcentral.date.DateHelper;

public abstract class Loggable {

	protected LogFile logFile = null;
	protected LogFileHelper logFileHelper = null;
	protected String name = null;
	protected String logTableBodyId = null;
	protected String logTableRowTag = null;
	private boolean hasTableBody = false;
	
	public Loggable(String name) {
		this.logFileHelper = new LogFileHelper();
		this.name = name;
		this.logTableBodyId = name + "-logs";
		this.logTableRowTag = "<!-- chimp-central-" + name + "-log-table-row -->";
	}
	
	abstract LogFile getLogFile();
	
	String getName() {
		return this.name;
	}
	
	private void createTableBody() {
		String tableBodyHTML = logFileHelper.getLogTableBodyHTML();
		tableBodyHTML = tableBodyHTML.replace(Tags.logTableBodyIdTag, logTableBodyId);
		tableBodyHTML = tableBodyHTML.replace(Tags.logTableRowTag, logTableRowTag);
		if (this.name.equals("main")) {
			tableBodyHTML = tableBodyHTML.replace(" style=\"display: none;\"", "");
		}
		getLogFile().createTableBody(tableBodyHTML);
		hasTableBody = true;
	}
	
	private String getMessage(String message, boolean isWarning) {
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
	
	public void info(String message) {
		if (!hasTableBody) createTableBody();
		getLogFile().log(this.logTableRowTag, getMessage(message, false));
	}
	
	public void warn(String message) {
		if (!hasTableBody) createTableBody();
		getLogFile().log(this.logTableRowTag, getMessage(message, true));
	}
	
	void toButton(String name, String message) {
	}
	
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
