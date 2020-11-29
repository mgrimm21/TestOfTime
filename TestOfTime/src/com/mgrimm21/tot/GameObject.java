package com.mgrimm21.tot;

import java.awt.Graphics;

public class GameObject {

	private float x, y, velX = 0, velY = 0;
	private int width, height;
	private Sprite sprite;
	
	public GameObject(float x, float y, int width, int height, String spriteName) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		sprite = new Sprite(spriteName);
	}
	
	public void tick() {
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g) {
		sprite.render(g, (int)x, (int)y, width, height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
