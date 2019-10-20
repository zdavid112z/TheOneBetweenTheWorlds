package com.ducksofts.ld30.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.core.GameState;
import com.ducksofts.ld30.entity.Player;
import com.ducksofts.ld30.level.Level;
import com.ducksofts.ld30.level.Level1;
import com.ducksofts.ld30.level.Level2;
import com.ducksofts.ld30.level.Level3;
import com.ducksofts.ld30.level.Level4;
import com.ducksofts.ld30.level.util.Input;
import com.ducksofts.ld30.level.util.Maths;

public class Display {

	public int w, h;

	public Level level;

	public static final int LEVEL_COUNT = 4;

	private BufferedImage image;
	private int[] pixels;

	public GameState gs;

	private Random r;
	private int back;

	private int timer = 0;

	public int xOff = 0;
	public int yOff = 0;

	private static int[] prices;

	private void setNewBack() {
		back = r.nextInt(4);
	}

	public Display(int w, int h) {
		prices = new int[5];
		prices[0] = 5;
		prices[1] = 10;
		prices[2] = 15;
		prices[3] = 25;
		prices[4] = 1000000000;
		r = new Random();
		gs = GameState.MENU;
		setNewBack();
		this.w = w;
		this.h = h;
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	public void update() {
		if (gs == GameState.INGAME) {
			level.update();
			if (Input.getKeyDown(KeyEvent.VK_ESCAPE)) {
				gs = GameState.PAUSED;
			}
		} else if (gs == GameState.MENU) {
			if (Input.getBtn() == 1) {
				if (Maths.inside(Input.getX(), Input.getY(), 111, 30, 128, 50)) {
					gs = GameState.INGAME;
					int le = r.nextInt(LEVEL_COUNT);
					if (le == 0) {
						level = new Level1();
					} else if (le == 1) {
						level = new Level2();
					} else if (le == 2) {
						level = new Level3();
					} else if (le == 3) {
						level = new Level4();
					}
				} else if (Maths.inside(Input.getX(), Input.getY(), 111, 100,
						128, 50)) {
					gs = GameState.HELP;
				} else if (Maths.inside(Input.getX(), Input.getY(), 111, 170,
						128, 50)) {
					System.gc();
					System.exit(0);
				}
			}
		} else if (gs == GameState.HELP) {
			if (Input.getKeyDown(KeyEvent.VK_ENTER))
				gs = GameState.MENU;
		} else if (gs == GameState.UPGRADES) {
			if (Input.getBtnDown() == 1) {
				if (Maths.inside(Input.getX(), Input.getY(), 15, 31, 128, 50)) {
					if (Player.score >= prices[Player.speedLevel]) {
						Player.score -= prices[Player.speedLevel];
						Player.speedLevel++;
					}
				} else if (Maths.inside(Input.getX(), Input.getY(), 15, 111,
						128, 50)) {
					if (Player.score >= prices[Player.powerLevel]) {
						Player.score -= prices[Player.powerLevel];
						Player.powerLevel++;
					}
				} else if (Maths.inside(Input.getX(), Input.getY(), 15, 191,
						128, 50)) {
					if (Player.score >= prices[Player.maxHpLevel]) {
						Player.score -= prices[Player.maxHpLevel];
						Player.maxHpLevel++;
					}
				} else if (Maths.inside(Input.getX(), Input.getY(), 195, 31,
						128, 50)) {
					if (Player.score >= 20 && !Player.hasTech) {
						Player.score -= 20;
						Player.hasTech = true;
					}
				} else if (Maths.inside(Input.getX(), Input.getY(), 195, 111,
						128, 50)) {
					if (Player.score >= 30 && !Player.hasCandy) {
						Player.score -= 30;
						Player.hasCandy = true;
					}
				} else if (Maths.inside(Input.getX(), Input.getY(), 195, 191,
						128, 50)) {
					gs = GameState.INGAME;
					int le = r.nextInt(LEVEL_COUNT);
					level.reset();
					if (le == 0) {
						level = new Level1();
					} else if (le == 1) {
						level = new Level2();
					} else if (le == 2) {
						level = new Level3();
					} else if (le == 3) {
						level = new Level4();
					}
				}
			}
		} else if (gs == GameState.PAUSED) {
			if (Input.getKeyDown(KeyEvent.VK_ESCAPE)) {
				gs = GameState.INGAME;
			} else if (Input.getKeyDown(KeyEvent.VK_ENTER)) {
				gs = GameState.UPGRADES;
			}
		} else if (gs == GameState.DEAD) {
			timer++;
			if (timer == 44) {
				timer = 0;
				gs = GameState.MENU;
			}
		}
	}

	public void render(Graphics g, int cw, int ch) {
		Graphics gr = image.getGraphics();
		gr.setFont(new Font("Arial", Font.BOLD, 20));
		gr.setColor(Color.BLACK);
		if (gs == GameState.INGAME) {
			level.render(this);
			gr.drawString("HP:" + level.player.getHealth(), 0, 20);
			gr.drawString("Score:" + Player.score, 0, 40);
			gr.drawString(
					"Time:"
							+ level.getTime()
							/ 60
							+ ":"
							+ ((level.getTime() % 60 < 10) ? ("0" + level
									.getTime() % 60) : level.getTime() % 60),
					0, 60);
		} else if (gs == GameState.MENU) {
			drawGUI(Images.BACK[back], 0, 0);
			if (Maths.inside(Input.getX(), Input.getY(), 111, 30, 128, 50)) {
				drawGUI(Images.START_H, 111, 30);
			} else {
				drawGUI(Images.START_N, 111, 30);
			}
			if (Maths.inside(Input.getX(), Input.getY(), 111, 100, 128, 50)) {
				drawGUI(Images.HELP_H, 111, 100);
			} else {
				drawGUI(Images.HELP_N, 111, 100);
			}
			if (Maths.inside(Input.getX(), Input.getY(), 111, 170, 128, 50)) {
				drawGUI(Images.EXIT_H, 111, 170);
			} else {
				drawGUI(Images.EXIT_N, 111, 170);
			}
		} else if (gs == GameState.HELP) {
			drawGUI(Images.BACK[back], 0, 0);
			drawGUI(Images.HELP, 0, 0);
		} else if (gs == GameState.UPGRADES) {
			drawGUI(Images.BACK[back], 0, 0);
			drawGUI(Images.SPEED, 15, 6);
			drawGUI(Images.BAR[Player.speedLevel], 15, 31);
			drawGUI(Images.POWER, 15, 86);
			drawGUI(Images.BAR[Player.powerLevel], 15, 111);
			drawGUI(Images.HEALTH, 15, 166);
			drawGUI(Images.BAR[Player.maxHpLevel], 15, 191);
			if (!Player.hasTech)
				drawGUI(Images.TECHWORLD, 195, 31);
			if (!Player.hasCandy)
				drawGUI(Images.CANDYLAND, 195, 111);
			if (Maths.inside(Input.getX(), Input.getY(), 195, 191, 128, 50)) {
				drawGUI(Images.NEWLEVEL_H, 195, 191);
			} else {
				drawGUI(Images.NEWLEVEL_N, 195, 191);
			}
			gr.drawString("Score:" + Player.score, 215, 30);
		} else if (gs == GameState.PAUSED) {
			level.render(this);
			gr.setFont(new Font("Arial", Font.BOLD, 20));
			gr.setColor(Color.BLACK);
			gr.drawString("HP:" + level.player.getHealth(), 0, 20);
			gr.drawString("Score:" + Player.score, 0, 40);
			gr.drawString(
					"Time:" + level.getTime() / 60 + ":" + level.getTime() % 60,
					0, 60);
			drawGUI(Images.PAUSED, 0, 0);
		} else if (gs == GameState.DEAD) {
			level.render(this);
			drawGUI(Images.BLINK[(44 - timer) / 8], 0, 0);
		}
		g.drawImage(image, 0, 0, cw, ch, null);
	}

	public void drawGUI(PImage im, int x, int y) {
		for (int i = 0; i < im.w; i++) {
			if (i + x >= w)
				continue;
			if (i + x < 0)
				continue;
			for (int j = 0; j < im.h; j++) {
				if (j + y >= h)
					continue;
				if (j + y < 0)
					continue;
				if (im.pixels[i + j * im.w] == 0xffff00ff)
					continue;
				Core.core.display.pixels[(i + x) + (j + y) * w] = im.pixels[i
						+ j * im.w];
			}
		}
	}

	public void drawImage(PImage im, int x, int y) {
		x -= xOff;
		y -= yOff;
		if (x >= w)
			return;
		if (y >= h)
			return;
		if (x + im.w < 0)
			return;
		if (y + im.h < 0)
			return;
		for (int i = 0; i < im.w; i++) {
			if (i + x >= w)
				continue;
			if (i + x < 0)
				continue;
			for (int j = 0; j < im.h; j++) {
				if (j + y >= h)
					continue;
				if (j + y < 0)
					continue;
				if (im.pixels[i + j * im.w] == 0xffff00ff)
					continue;
				Core.core.display.pixels[(i + x) + (j + y) * w] = im.pixels[i
						+ j * im.w];
			}
		}
	}

}
