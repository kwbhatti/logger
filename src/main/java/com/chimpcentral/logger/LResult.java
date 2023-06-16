package com.chimpcentral.logger;

public enum LResult {

	pass ("rgb(100, 180, 100)"),
	fail ("rgb(240, 50, 50)"),
	skip ("rgb(25, 160, 240)"),
	;
	
	String color = null;
	
	private LResult(String color) {
		this.color = color;
	}
}
