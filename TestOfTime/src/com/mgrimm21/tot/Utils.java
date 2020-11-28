package com.mgrimm21.tot;

import java.awt.GraphicsEnvironment;
import java.io.File;

public class Utils {
	
	public static final String USER = System.getProperty("user.name");
	public static final String PATH = "C:\\Users\\" + USER + "\\TestOfTime";
	public static final String PATH_CONFIGS = PATH + "\\Configs";
	public static final String PATH_LOGS = PATH + "\\Logs";
	
	public static Configuration settings;

	public static void setupFiles() {
		File file = new File(PATH);
		file.mkdirs();
		file = new File(PATH_CONFIGS);
		file.mkdir();
		file = new File(Utils.PATH_LOGS);
		file.mkdir();
		settings = new Configuration("settings.tot");
		setDefaults();
	}
	
	private static void setDefaults() {
		if (!settings.exists("width")) {
			settings.set("width", GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth());
		}
		if (!settings.exists("height")) {
			settings.set("height", GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight());
		}
	}
	
	public static void forceDefaults() {
		settings.reset();
		setDefaults();
	}
}
