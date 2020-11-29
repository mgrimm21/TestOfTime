package com.mgrimm21.tot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{

	private boolean[] buttons = new boolean[2000];
	private boolean[] buttonsLast = new boolean[2000];
	
	public boolean isButtonDown(int button) {
		return buttons[button];
	}
	
	public boolean isNewButtonDown(int button) {
		if (buttons[button] && !buttonsLast[button]) return true;
		return false;
	}
	
	public void tick() {
		for (int i = 0; i < 200; i++) {
			buttonsLast[i] = false;
			if(buttons[i]) buttonsLast[i] = true;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {		
		buttons[arg0.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {	
		buttons[arg0.getButton()] = false;
	}

}
