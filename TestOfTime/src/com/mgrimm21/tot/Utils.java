package com.mgrimm21.tot;

import java.io.File;
import java.io.IOException;

public class Utils {
	
	public static final String USER = System.getProperty("user.name");
	public static final String PATH = "C:\\Users\\" + USER + "\\TestOfTime";
	public static final String PATH_SETTINGS = PATH + "\\settings.tot";

	public static void checkFiles() {
		File file = new File(PATH);
		if (!file.exists()) {
			file.mkdirs();
			Logger.log(Logger.INFO, "Directory not found, creating now");
		}
		file = new File(PATH_SETTINGS);
		if (!file.exists()) {
			try {
				Logger.log(Logger.INFO, "Settings not found, creating now");
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
