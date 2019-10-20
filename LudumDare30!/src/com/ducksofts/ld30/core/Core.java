package com.ducksofts.ld30.core;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;
import com.ducksofts.ld30.level.Level;
import com.ducksofts.ld30.level.tile.Tile;
import com.ducksofts.ld30.level.util.Audio;
import com.ducksofts.ld30.level.util.Input;

public class Core extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 350;
	public static final int HEIGHT = 250;
	public static final int SCALE = 3;
	public static final int UPS = 40;
	public static final String TITLE = "The one between the worlds";

	public static Core core;

	private boolean running = false;
	private boolean sync = true;

	private JFrame frame;
	private Thread main;
	private Input input;
	public Display display;

	public static void main(String[] args) {
		core = new Core();
		core.frame.add(core);
		core.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		core.frame.setTitle(TITLE);
		core.frame.setResizable(true);
		core.frame.pack();
		core.frame.setLocationRelativeTo(null);
		core.frame.setVisible(true);
		core.frame.setEnabled(true);
		core.start();
	}

	public Core() {
		frame = new JFrame();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		input = new Input();
		addKeyListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);
		Level.register();
		Audio.load();
		Images.load();
		Tile.init();
		display = new Display(WIDTH, HEIGHT);
	}

	public void run() {
		long t1 = getTime();
		long t2 = getTime();
		int time = 1000 / UPS;
		int u = 0;
		int f = 0;
		double delta = 0;
		while (running) {
			delta += (getTime() - t1) / time;
			while (delta >= 1) {
				delta--;
				t1 = getTime();
				u++;
				update();
				if (sync) {
					f++;
					render();
				}
			}
			if (!sync) {
				f++;
				render();
			}
			if (getTime() - t2 >= 1000) {
				t2 = getTime();
				//frame.setTitle(TITLE + " : " + u + " : " + f);
				u = 0;
				f = 0;
			}
		}
		stop();
	}

	private long getTime() {
		return System.nanoTime() / 1000000;
	}

	private synchronized void start() {
		if (running)
			return;
		running = true;
		main = new Thread(this, "Display");
		main.start();
	}

	private synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			main.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		display.update();
		input.update(getWidth(), getHeight());
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		display.render(g, getWidth(), getHeight());
		g.dispose();
		bs.show();
	}

}
