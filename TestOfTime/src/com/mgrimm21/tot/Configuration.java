package com.mgrimm21.tot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Configuration {
	
	public static final int ERROR = -482942342;
	
	private File file;
	
	
	public Configuration(String configName) {
		file = new File(Utils.PATH_CONFIGS + "\\" + configName);
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void set(String key, int data) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file, true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(key + ":" + data);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	
	public String getString(String key) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
			       String[] tokens = line.split(":");
			       if (tokens[0].equalsIgnoreCase(key)) {
			    	   br.close();
			    	   return tokens[1];
			       }
			    }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getInt(String key) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
			       String[] tokens = line.split(":");
			       if (tokens[0].equalsIgnoreCase(key)) {
			    	   br.close();
			    	   return Integer.parseInt(tokens[1]);
			       }
			    }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public boolean exists(String key) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
			       String[] tokens = line.split(":");
			       if (tokens[0].equalsIgnoreCase(key)) {
			    	   br.close();
			    	   return true;
			       }
			    }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void reset() {
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
