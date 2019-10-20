package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;
import com.ducksofts.ld30.level.util.Audio;
import com.ducksofts.ld30.level.util.Maths;
import com.ducksofts.ld30.level.util.Vector2;

public class Nyan extends Entity implements Mob {

	private int frame = 0;
	private int timer = 0;
	private int change = 5;

	private int speed = 2;

	private int timer2 = 0;
	private int damage = -5;
	private int attackDelay = 40;
	private int attackDist = 40;

	private int hp;

	public Nyan(int x, int y, int dim) {
		super(x, y, 32, 24, dim,2);
		col = true;
		hp = 120;
	}

	public void update() {
		timer++;
		if (timer == change) {
			timer = 0;
			frame++;
			if (frame == 2)
				frame = 0;
		}
		updateCenter();
		Vector2 dir = Maths.getMots(cx, cy, Core.core.display.level.player.cx,
				Core.core.display.level.player.cy);
		motX = (int) (dir.x * (float) speed);
		motY = (int) (dir.y * (float) speed);
		if (shouldAdd(motX, motY, dim)) {
			// System.out.println(dir.x + " : " + dir.y);
			x += motX;
			y += motY;
		}
		updateCenter();
		if (motX < 0) {
			Core.core.display.level.ent.add(new RainbowTrail(cx + 12, y + 4,
					dim, 60));
		} else {
			Core.core.display.level.ent.add(new RainbowTrail(cx - 13, y + 4,
					dim, 60));
		}
		timer2++;
		if (timer2 == attackDelay) {
			timer2 = 0;
			if (Maths.dist(cx, cy, Core.core.display.level.player.cx,
					Core.core.display.level.player.cy) < attackDist) {
				Core.core.display.level.player.damage(damage);
			}
		}
	}

	private int getFrame() {
		if (motX < 0) {
			return frame + 2;
		} else {
			return frame;
		}
	}

	public void render(Display d) {
		d.drawImage(Images.NYAN[getFrame()], x, y);
	}

	public int getHealth() {
		return hp;
	}

	public void damage(int amount) {
		hp -= amount;
		Audio.HIT_NYAN.play();
	}

	public void die() {
		Core.core.display.level.ent.remove(this);
	}
}
