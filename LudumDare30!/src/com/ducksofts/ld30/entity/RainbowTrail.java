package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;

public class RainbowTrail extends Entity {

	private int timer = 0;
	private int die;

	public RainbowTrail(int x, int y, int dim, int dis) {
		super(x, y, 0, 0, dim,3);
		die = dis;
	}

	public void update() {
		timer++;
		if (timer == die)
			Core.core.display.level.ent.remove(this);
	}

	public void render(Display d) {
		d.drawImage(Images.RAINBOW_TRAIL, x, y);
	}

}
