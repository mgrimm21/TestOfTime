package com.mgrimm21.tot;

import java.io.File;
import java.io.IOException;

public class Utils {
	
	private static final String USERNAME = System.getProperty("user.name");
	public static final String PATH = "C:\\Users\\" + USERNAME + "\\TestOfTime";

	public static void checkFiles() {
		new File(PATH).mkdirs();
		File settings = new File(PATH + "\\settings.tot");
		if (!settings.exists()) {
			try {
				Logger.log(Logger.INFO, "settings.tot missing, creating now");
				settings.createNewFile();
			} catch (IOException e) {
				Logger.log(Logger.ERROR, e.getMessage());
			}
		}
	}
	
}
