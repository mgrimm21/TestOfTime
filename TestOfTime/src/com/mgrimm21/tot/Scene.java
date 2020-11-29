package com.mgrimm21.tot;

import java.awt.Graphics;
import java.util.ArrayList;

public class Scene {
	
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	
	public void render(Graphics g) {
		synchronized (gameObjects){
			for(GameObject o: gameObjects) o.render(g);
		}
		
	}
	
	public void tick() {
		synchronized (gameObjects) {
			for(GameObject o: gameObjects) o.tick();
		}
	}
	
	public void removeObject(GameObject o) {
		synchronized (gameObjects) {
			gameObjects.remove(o);
		}
	}
	
	public void addObject(GameObject o) {
		synchronized (gameObjects) {
			gameObjects.add(o);
		}
	}
	
	public boolean containsObject(GameObject o) {
		synchronized (gameObjects) {
			return gameObjects.contains(o);
		}
	}

}
