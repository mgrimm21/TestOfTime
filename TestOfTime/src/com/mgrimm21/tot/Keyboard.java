package com.mgrimm21.tot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	private boolean[] keys = new boolean[2000];
	private boolean[] keysLast = new boolean[2000];
	
	public boolean isKeyDown(int key) {
		return keys[key];
	}
	
	public boolean isNewKeyDown(int key) {
		if (keys[key] && !keysLast[key]) return true;
		return false;
	}
	
	public void tick() {
		for (int i = 0; i < 200; i++) {
			keysLast[i] = false;
			if(keys[i]) keysLast[i] = true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
