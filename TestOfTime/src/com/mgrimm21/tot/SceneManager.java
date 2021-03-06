package com.mgrimm21.tot;

import java.awt.Graphics;
import java.util.HashMap;

public class SceneManager {

	private HashMap<String, Scene> scenes = new HashMap<String, Scene>();
	private Scene activeScene;
	private String activeSceneName;
	
	public SceneManager() {
	}
	
	public void tick() {
		if (activeScene!= null) activeScene.tick();
	}
	
	public void render(Graphics g) {
		if (activeScene!= null) activeScene.render(g);
	}
	
	public void addScene(String name, Scene scene) {
		scenes.put(name, scene);
	}
	
	public void removeScene(String name) {
		scenes.remove(name);
	}
	
	public void setActiveScene(String name) {
		activeSceneName = name;
		activeScene = scenes.get(name);
	}
	
	public String getActiveSceneName() {
		return activeSceneName;
	}
	
}
