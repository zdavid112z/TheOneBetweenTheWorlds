package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;
import com.ducksofts.ld30.level.util.Audio;

public class Shard extends Entity {

	private int timer = 0;
	private int change = 7;
	private int maxOff = 2;
	private int off;
	private int speed = 1;
	private int dir = 1;

	public Shard(int x, int y, int dim) {
		super(x, y, 12, 12, dim, 1);
	}

	public void update() {
		if (collides(Core.core.display.level.player)) {
			Core.core.display.level.ent.remove(this);
			Player.score++;
			Audio.COIN.play();
		}
		timer++;
		if (timer == change) {
			timer = 0;
			y += dir * speed;
			off += dir * speed;
			if (Math.abs(off) >= maxOff) {
				dir = (dir == 1) ? -1 : 1;
			}
		}
	}

	public void render(Display d) {
		d.drawImage(Images.SHARD, x, y);
	}

}
