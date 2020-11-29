package com.mgrimm21.tot;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class TestOfTime extends Canvas implements Runnable{

	private static final long serialVersionUID = -2359993784113990952L;
	
	private Thread gameThread;
	private JFrame frame;
	private boolean running = false;
	private int width, height;
	private Keyboard keyboard = new Keyboard();
	private Mouse mouse = new Mouse();
	
	public TestOfTime() {
		width = Utils.settings.getInt("width");
		height = Utils.settings.getInt("height");
		Dimension size = new Dimension(width, height);
		this.addKeyListener(keyboard);
		setPreferredSize(size);
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setTitle("Test Of Time");
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		this.setFocusable(true);
		this.requestFocus();
		start();
	}
	
	private void tick() {
		keyboard.tick();
		mouse.tick();
		if(keyboard.isKeyDown(KeyEvent.VK_ESCAPE)) System.exit(0);
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		bs.show();
		g.dispose();
	}
	
	public synchronized void start() {
		gameThread = new Thread(this, "Display");
		running = true;
		gameThread.start();
	}
	
	public synchronized void stop() {
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		 long lastTime = System.nanoTime();
		    double amountOfTicks = 60.0;
		    double ns = 1000000000 / amountOfTicks;
		    double delta = 0;
		    long timer = System.currentTimeMillis();
		    int frames = 0 ;
		    int ticks = 0;
		    while (running) {
		        long now = System.nanoTime();
		        delta += (now - lastTime) / ns;
		        lastTime = now;
		        while (delta >= 1) {
		            tick();
		            ticks++;
		            delta--;
		        }
		        if(running)
		            render();
		        frames++;

		        if(System.currentTimeMillis() - timer > 1000) {
		            timer += 1000;
		            System.out.println("FPS: " + frames + " TICKS: " + ticks);
		            frames = 0;
		            ticks = 0;
		        }
		    }
		    stop();
	}

	

	

}
