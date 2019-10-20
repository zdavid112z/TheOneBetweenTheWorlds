package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;
import com.ducksofts.ld30.level.util.Audio;
import com.ducksofts.ld30.level.util.Maths;
import com.ducksofts.ld30.level.util.Vector2;

public class FlyHH extends Entity implements Mob {

	private int damage = 10;
	private int timer2 = 0;
	private int attackDelay = 20;
	private int attackDist = 48;

	private boolean angel;
	private int timer = 0;
	private int change = 10;
	private int frame = 0;

	private int hp;

	private int speed = 2;

	private Vector2 dir;

	public FlyHH(int x, int y, boolean angel, int dim) {
		super(x, y, 32, 48, dim, 2);
		col = false;
		hp = 100;
		this.angel = angel;
	}

	public void update() {
		if (hp <= 0) {
			die();
			return;
		}
		timer++;
		if (timer >= change) {
			timer = 0;
			frame++;
			if (frame == 2)
				frame = 0;
		}
		updateCenter();
		dir = Maths.getMots(cx, cy, Core.core.display.level.player.cx,
				Core.core.display.level.player.cy);
		motX = (int) (dir.x * (float) speed);
		motY = (int) (dir.y * (float) speed);
		// if (shouldAdd(motX, motY, dim)) {
		x += motX;
		y += motY;
		// }
		updateCenter();
		timer2++;
		if (timer2 == attackDelay) {
			timer2 = 0;
			if (Maths.dist(cx, cy, Core.core.display.level.player.cx,
					Core.core.display.level.player.cy) < attackDist) {
				if (Core.core.display.level.player.dim == dim)
					if(Core.core.display.level.player.blocking)
						damage(damage / 2);
					else Core.core.display.level.player.damage(damage);
			}
		}
	}

	public void render(Display d) {
		d.drawImage((angel) ? Images.ANGEL[frame] : Images.DEMON[frame], x, y);
	}

	public int getHealth() {
		return hp;
	}

	public void damage(int amount) {
		hp -= amount;
		Audio.HIT_ANGEL.play();
	}

	public void die() {
		Core.core.display.level.ent.remove(this);
		Player.score += 20;
	}

}
