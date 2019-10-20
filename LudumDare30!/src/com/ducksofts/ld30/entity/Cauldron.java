package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;

public class Cauldron extends Entity {

	private int timer = 0;
	private int change = 4;
	private int frame = 0;

	public Cauldron(int x, int y, int dim) {
		super(x, y, 48, 32, dim,3);
	}

	public void update() {
		timer++;
		if (timer == change) {
			timer = 0;
			frame++;
			if (frame == 4)
				frame = 0;
		}
	}

	public void render(Display d) {
		d.drawImage(Images.CAULDRON[frame], x, y);
	}

}
