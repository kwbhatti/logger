package com.chimpcentral.simpleLogger;

public class Log {

	private String name = null;
	
	public Log(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public <T> void info(T message) {
		if (message instanceof String) System.out.println(((String) message).replaceAll("<br>", "/n"));
		else System.out.println(message);
	}
}
