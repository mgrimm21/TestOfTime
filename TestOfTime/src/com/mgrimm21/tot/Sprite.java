package com.mgrimm21.tot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private BufferedImage image;
	
	public Sprite(String file) {
		long stime = System.currentTimeMillis();
		try {
			image = ImageIO.read(new File("res\\sprites\\" + file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis()-stime;
		Logger.log(Logger.INFO, "Loaded sprite " + file + " in " + time + "ms.");
	}
	
	public void render(Graphics g, int x, int y, int width, int height) {
		g.setColor(Color.white);
		g.drawImage(image, x, y, width, height, null);
	}

}
