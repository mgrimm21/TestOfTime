package com.mgrimm21.tot;

import java.awt.Graphics;

public class Map {
	private int mapWidth = Utils.settings.getInt("width")/32;
	private int mapHeight = Utils.settings.getInt("height")/32;
	private Tile[][] tileMap = new Tile[mapWidth][mapHeight];
	
	public Map() {
		for(int x = 0; x < mapWidth; x++) {
			for (int y = 0; y < mapHeight; y++) {
				tileMap[x][y] = new Tile(x*32,y*32,"testTile.png");
			}
		}
	}
	
	public void render(Graphics g) {
		for(int x = 0; x < mapWidth; x++) {
			for (int y = 0; y < mapHeight; y++) {
				tileMap[x][y].render(g);
			}
		}
	}

}
