package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;

public class Robo extends Entity {

	private int timer = 0;
	private int change = 5;
	private int frame = 0;

	public Robo(int x, int y, int dim) {
		super(x, y, 32, 48, dim,3);
	}

	public void update() {
		timer++;
		if(timer == change){
			timer = 0;
			frame++;
			if(frame == 4)
				frame = 0;
		}
	}

	public void render(Display d) {
		d.drawImage(Images.ROBO[frame], x, y);
	}

}
