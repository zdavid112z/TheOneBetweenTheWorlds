package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;

public class Cloud extends Entity {

	private int speed;

	public Cloud(int x, int y, int dim) {
		super(x, y, 64, 32, dim, 3);
		this.speed = 1;
	}

	public void update() {
		x += speed;
		if (x < 0)
			x = 32 * Core.core.display.level.terrain[0].w;
		if (x >= 32 * Core.core.display.level.terrain[0].w)
			x = 0;
	}

	public void render(Display d) {
		d.drawImage(Images.CLOUD, x, y);
	}

}
