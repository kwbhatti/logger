package com.chimpcentral;

import java.util.ArrayList;
import java.util.List;

import com.chimpcentral.date.DateHelper;

public abstract class Log {

	private String name = null;
	private List<Log> nodes = new ArrayList<Log>();
	private StringBuilder content = new StringBuilder();
	
	public Log(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	public List<Log> getNodes() {
		return this.nodes;
	}
	
	public StringBuilder getContent() {
		return this.content;
	}
	
	public boolean hasNodes() {
		return this.nodes.size() > 0 ? true : false;
	}
	
	public NodeLog createLog(String name) {
		NodeLog log = new NodeLog(name);
		this.nodes.add(log);
		return log;
	}
	
	private void appendInfo(LogLevel logLevel, Object message) {
		content.append("<tr>");
		if (logLevel == LogLevel.INFO) content.append("<td>info</td>");
		else if (logLevel == LogLevel.WARN) content.append("<td class=\"warning\">warning</td>");
		content.append("<td>" + new DateHelper().getCurrentTimeStamp() + "</td>");
		content.append("<td>" + message + "</td>");
		content.append("</tr>");
	}
	
	public void info(Object message) {
		appendInfo(LogLevel.INFO, message);
	}
	
	public void warn(Object message) {
		appendInfo(LogLevel.WARN, message);
	}

}
