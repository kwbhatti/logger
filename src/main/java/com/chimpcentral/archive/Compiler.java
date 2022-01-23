package com.chimpcentral.archive;

import java.io.IOException;
import java.util.List;

import com.chimpcentral.io.FileStatus;
import com.chimpcentral.io.FlatFile;

public class Compiler {

	private Logger logger = null;
	private LoggerInfo loggerInfo = null;
	private ContentHelper fileHelper = null;
	private FlatFile logFile = null;
	
	public Compiler(Logger logger) {
		this.logger = logger;
		this.loggerInfo = this.logger.getLoggerInfo();
		this.fileHelper = new ContentHelper(this.loggerInfo.getResourcesDir());
	}
	
	private void createLogFile(String filepath) {
		try {
			this.logFile =  new FlatFile(filepath, FileStatus.NEW);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void appendContentToLogFile(String content) {
		try {
			this.logFile.appendContent(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private StringBuilder getTableHeader() {
		return new StringBuilder()
						.append("<table class=\"table table-responsive\">")
						.append("<thead>")
						.append("<tr>")
						.append("<th style=\"width: 10%;\">log info</th>")
						.append("<th style=\"width: 15%;\">time</th>")
						.append("<th style=\"width: 75%;\">message</th>")
						.append("</tr>")
						.append("</thead>");
	}
	
	private StringBuilder getTableBodyStart() {
		return new StringBuilder().append("<tbody>");
	}
	
	private StringBuilder getTableBodyEnd() {
		return new StringBuilder().append("</tbody></table>");
	}
	
	private StringBuilder getLogContainer() {
		return new StringBuilder().append("<div class=\"container mt-3\">");
	}
	
	private void processMainLog(Log log) {
		String content = log.getContent().toString();
		if (content != null && !content.equals("")) {
			appendContentToLogFile(getTableHeader().toString());
			appendContentToLogFile(getTableBodyStart().toString());
			appendContentToLogFile(content);
			appendContentToLogFile(getTableBodyEnd().toString());
			appendContentToLogFile("</div>");//this closes the main text

		}
		if (log.hasNodes()) processLogs(log.getNodes());
	}
	
	private void processLog(Log log) {
		String content = log.getContent().toString();
		appendContentToLogFile(getLogContainer().toString());
		String logStartContent = this.fileHelper.getNodeLogStartFileContent().toString().replaceAll("<scenario name goes here>", log.getName().replaceAll(" ", "_"));
		appendContentToLogFile(logStartContent);
		appendContentToLogFile(getTableHeader().toString());
		appendContentToLogFile(getTableBodyStart().toString());
		appendContentToLogFile(content);
		appendContentToLogFile(getTableBodyEnd().toString());
		appendContentToLogFile(this.fileHelper.getNodeLogEndFileContent().toString());
		if (log.hasNodes()) processLogs(log.getNodes());
		else appendContentToLogFile("</div></div>");
	}
	
	private void processLogs(List<Log> logs) {
		for (Log log: logs) {
			processLog(log);
		}
		appendContentToLogFile("</div></div>");
	}
	
	public void compile() {
		createLogFile(loggerInfo.getFilepath());
		String baseStartContent = this.fileHelper.getBaseStartFileContent()
										.replace("${title}$", this.loggerInfo.getTitle())
										.replace("${heading}$", this.loggerInfo.getHeading())
										.replace("${sub-heading}$", this.loggerInfo.getSubHeading());
		appendContentToLogFile(baseStartContent);
		appendContentToLogFile(this.fileHelper.getMainLogStartFileContent());
		processMainLog(this.logger.getMainLog());
		
//		startBaseLog();
//		startMainLog();
		
//		Log log = this.logger.mainLog;
//		while (log.hasNodes()) {
//			List<Log> logs = log.getNodes();
//		}
		
	}
}
