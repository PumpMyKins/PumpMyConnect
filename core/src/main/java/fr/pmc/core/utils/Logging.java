package fr.pmc.core.utils;

import java.util.logging.Logger;

public abstract class Logging {

	private static Logger logger;
	
	public static void setLogger(Logger l) {
		
		logger = l;
		
	}
	
	public static Logger getLogger() {
		
		return logger;
		
	}
	
}
