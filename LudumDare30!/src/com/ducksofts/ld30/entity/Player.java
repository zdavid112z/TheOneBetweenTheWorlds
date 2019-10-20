package com.ducksofts.ld30.entity;

import static java.awt.event.KeyEvent.*;

import java.awt.event.KeyEvent;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.core.GameState;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;
import com.ducksofts.ld30.level.util.Audio;
import com.ducksofts.ld30.level.util.Input;

public class Player extends Entity implements Mob {

	public static int speedLevel = 0;
	public static int powerLevel = 0;
	public static int maxHpLevel = 0;

	public int maxHp = 100;
	public int damage = 20;
	public int range = 24;

	public static boolean hasHeaven = true;
	public static boolean hasHell = true;
	public static boolean hasCandy = false;
	public static boolean hasTech = false;

	private int at = 0;
	private int atdur = 10;
	private int atdel = 25;

	private int timer = 0;
	private int frameChange = 7;
	private int curFrame = 0;

	private int hp;
	private float jmot;
	private int speed;

	private boolean right = true;
	private boolean moving = false;
	private boolean jumping = false;
	public boolean blocking = false;
	private boolean attacking = false;
	private boolean attackCooldowned = true;

	public static int score;

	public static void reset() {
		speedLevel = 0;
		powerLevel = 0;
		maxHpLevel = 0;
		score = 0;
		hasHeaven = true;
		hasHell = true;
		hasCandy = false;
		hasTech = false;
	}

	public Player(int x, int y, int dim) {
		super(x, y, 24, 24, dim, 1);
		speed = 2 + speedLevel;
		damage = 20 + powerLevel * 30;
		maxHp = 100 + maxHpLevel * 50;
		jmot = 0;
		col = true;
		hp = maxHp;
	}

	public void update() {
		motX = 0;
		jmot += (float) Core.core.display.level.gravity / 10.0f;
		timer++;
		if (timer == frameChange) {
			timer = 0;
			curFrame++;
			if (curFrame >= 4)
				curFrame = 0;
		}
		if (!attackCooldowned) {
			at++;
			if (at == atdur) {
				attacking = false;
			}
			if (at == atdel) {
				attackCooldowned = true;
			}
		}
		if (Input.getKey(VK_D)) {
			motX += speed;
			right = true;
			moving = true;
		}
		if (Input.getKey(VK_A)) {
			motX -= speed;
			right = false;
			moving = true;
		}
		if (motX == 0)
			moving = false;
		if (Input.getKeyDown(KeyEvent.VK_SPACE)) {
			if (!jumping) {
				if (attackCooldowned) {
					attacking = true;
					attackCooldowned = false;
					at = 0;
					updateCenter();
					attack((right) ? 12 + range / 2 : -12 - range / 2, 0,
							range, range, damage);
				}
			}
		}
		if (attacking)
			motX = 0;
		if (Input.getKey(VK_S)) {
			if (!jumping) {
				blocking = true;
				motX = 0;
			}
		} else
			blocking = false;
		if (Input.getKey(VK_W)) {
			jump();
		}
		if (shouldAdd(motX, 0, Core.core.display.level.curTer)) {
			x += motX;
		}
		motY = Core.core.display.level.gravity + (int) jmot;
		if (shouldAdd(0, motY - 1, Core.core.display.level.curTer)) {
			y += motY - 1;
		} else {
			if (motY > 0) {
				jmot = 0;
				jumping = false;
				// int ofs = 32 - (y + h) % 32;
				// if (ofs != 32)
				// y += ofs - 1;
			}
		}
		if (shouldAdd(0, 1, dim))
			y++;
		updateCenter();
		Core.core.display.xOff = cx - Core.WIDTH / 2;
		Core.core.display.yOff = cy - Core.HEIGHT / 2;
		if (Input.getKeyDown(VK_1)) {
			if (hasHeaven) {
				if (shouldAdd(0, 0, 0) && dim != 0) {
					dim = 0;
					Core.core.display.level.curTer = 0;
					Core.core.display.level.blink();
				}
			}
		} else if (Input.getKeyDown(VK_2)) {
			if (hasHell) {
				if (shouldAdd(0, 0, 1) && dim != 1) {
					dim = 1;
					Core.core.display.level.curTer = 1;
					Core.core.display.level.blink();
				}
			}
		} else if (Input.getKeyDown(VK_3)) {
			if (hasTech) {
				if (shouldAdd(0, 0, 2) && dim != 2) {
					dim = 2;
					Core.core.display.level.curTer = 2;
					Core.core.display.level.blink();
				}
			}
		} else if (Input.getKeyDown(VK_4)) {
			if (hasCandy) {
				if (shouldAdd(0, 0, 3) && dim != 3) {
					dim = 3;
					Core.core.display.level.curTer = 3;
					Core.core.display.level.blink();
				}
			}
		}
		if (hp > maxHp)
			hp = maxHp;
		if (hp <= 0)
			die();
	}

	public void jump() {
		if (!jumping) {
			jmot -= 3 * 2.65 + speedLevel / 2;
			jumping = true;
		}
	}

	public void render(Display d) {
		d.drawImage(Images.PLAYER[getFrame()], x, y + 1);
	}

	public int getFrame() {
		if (attacking) {
			if (right)
				return 12;
			else
				return 13;
		}
		if (blocking) {
			if (right)
				return 10;
			else
				return 11;
		}
		if (!moving || jumping) {
			if (right)
				return 0;
			else
				return 5;
		} else {
			if (right)
				return 1 + curFrame;
			else
				return 6 + curFrame;
		}
	}

	public int getHealth() {
		return hp;
	}

	public void damage(int amount) {
		if (amount < 0) {
			Audio.HEAL_PLAYER.play();
			if (blocking)
				hp -= amount * 2;
			else
				hp -= amount;
		} else {
			Audio.HIT_PLAYER.play();
			if (blocking)
				hp -= amount / 2;
			else
				hp -= amount;
		}
	}

	public void die() {
		Core.core.display.gs = GameState.DEAD;
		Audio.DEAD.play();
		reset();
	}

}
