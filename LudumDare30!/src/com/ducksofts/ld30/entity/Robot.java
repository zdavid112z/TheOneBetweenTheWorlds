package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;
import com.ducksofts.ld30.level.util.Audio;
import com.ducksofts.ld30.level.util.Maths;

public class Robot extends Entity implements Mob {

	private int speed = 3;
	private int seeDist = 128;
	private int frame = 0;
	private int timer = 0;
	private int change = 3;
	private int hp = 100;

	private int timer2 = 0;
	private int attackDelay = 50;
	private int damage = 25;
	private int attackDist = 32;

	public Robot(int x, int y, int dim) {
		super(x, y, 12, 60, dim, 2);
		col = true;
		hp = 300;
	}

	public void update() {
		timer++;
		if (timer == change) {
			timer = 0;
			frame++;
			if (frame == 4)
				frame = 0;
		}
		updateCenter();
		Core.core.display.level.player.updateCenter();
		if (Maths.dist(cx, cy, Core.core.display.level.player.cx,
				Core.core.display.level.player.cy) < seeDist) {
			if (Core.core.display.level.player.cx - cx > 0) {
				motX = speed;
			} else
				motX = -speed;
		} else {
			motX = 0;
		}
		if (shouldAdd(motX, 0, dim))
			x += motX;
		if (shouldAdd(0, Core.core.display.level.gravity + 1, dim))
			y += Core.core.display.level.gravity + 1;
		if (shouldAdd(0, 1, dim))
			y++;
		if (hp <= 0)
			die();
		updateCenter();
		timer2++;
		if (timer2 == attackDelay) {
			timer2 = 0;
			if (Maths.dist(cx, cy, Core.core.display.level.player.cx,
					Core.core.display.level.player.cy) < attackDist) {
				if (Core.core.display.level.player.blocking)
					damage(damage / 2);
				else
					Core.core.display.level.player.damage(damage);
			}
		}
	}

	private int getFrame() {
		if (motX == 0)
			return 0;
		else if (motX > 0)
			return frame + 1;
		else
			return frame + 5;
	}

	public void render(Display d) {
		d.drawImage(Images.ROBOT[getFrame()], x - 10, y - 3);
	}

	public int getHealth() {
		return hp;
	}

	public void damage(int amount) {
		hp -= amount;
		Audio.HIT_ROBOT.play();
	}

	public void die() {
		Core.core.display.level.ent.remove(this);
		Player.score += 35;
	}
}
