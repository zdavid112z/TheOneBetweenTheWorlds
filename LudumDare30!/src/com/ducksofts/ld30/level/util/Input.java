package com.ducksofts.ld30.level.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.ducksofts.ld30.core.Core;

public class Input implements MouseListener, MouseMotionListener, KeyListener {

	private static int w, h;
	private static boolean[] keys, keysDown, keysUp;
	private static int btn, btnUp, btnDown;
	private static int x, y;

	public Input() {
		keys = new boolean[1000];
		keysDown = new boolean[1000];
		keysUp = new boolean[1000];
	}

	public static boolean getKey(int code) {
		return keys[code];
	}

	public static boolean getKeyDown(int code) {
		return keysDown[code];
	}

	public static boolean getKeyUp(int code) {
		return keysUp[code];
	}

	public static int getBtn() {
		return btn;
	}

	public static int getBtnDown() {
		return btnDown;
	}

	public static int getBtnUp() {
		return btnUp;
	}

	public static int getX() {
		return (int) ((float) (Core.WIDTH * x) / (float) w);
	}

	public static int getY() {
		return (int) ((float) (Core.HEIGHT * y) / (float) h);
	}

	public void update(int w, int h) {
		for (int i = 0; i < keys.length; i++) {
			keysDown[i] = false;
			keysUp[i] = false;
		}
		btnDown = 0;
		btnUp = 0;
		Input.w = w;
		Input.h = h;
	}

	 
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		keysDown[e.getKeyCode()] = true;
	}

	 
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		keysUp[e.getKeyCode()] = true;
	}

	 
	public void keyTyped(KeyEvent e) {

	}

	 
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	 
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	 
	public void mouseClicked(MouseEvent e) {

	}

	 
	public void mouseEntered(MouseEvent e) {

	}

	 
	public void mouseExited(MouseEvent e) {

	}

	 
	public void mousePressed(MouseEvent e) {
		btn = e.getButton();
		btnDown = e.getButton();
	}

	 
	public void mouseReleased(MouseEvent e) {
		btn = 0;
		btnUp = e.getButton();
	}

}
