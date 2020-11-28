package com.mgrimm21.tot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	public static final int ALL = 0;
	public static final int DEBUG = 1;
	public static final int INFO = 2;
	public static final int WARN = 3;
	public static final int ERROR = 4;
	public static final int FATAL = 5;
	public static final int OFF = 6;
	private static final String[] LEVEL_NAMES = new String[] {"ALL","DEBUG","INFO","WARN","ERROR","FATAL"};
	private static int loggerLevel = 4;
	private static File file;
	
	static {
		File logFile = new File(Utils.PATH + "\\logs");
		logFile.mkdir();
		SimpleDateFormat formatter= new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		Date date = new Date(System.currentTimeMillis());
		logFile = new File(Utils.PATH + "\\logs\\" + formatter.format(date) + ".tot");
		try {
			logFile.createNewFile();
			file = logFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void log(final int LEVEL, String log) {
		SimpleDateFormat formatter= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String message = "[" + formatter.format(date) + "][" + LEVEL_NAMES[LEVEL] + "]: " + log;
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(message);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (loggerLevel <= LEVEL)System.out.println(message);
	}
	
	public static void setLevel(int level) {
		loggerLevel = level;
	}
	
	
}
