package com.ducksofts.ld30.entity;

import java.util.List;

import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.PImage;

public class Liquid extends Entity {

	private int timer = 0;
	private int change = 5;
	private int frame = 0;

	private PImage[] images;

	public Liquid(int x, int y, int dim, PImage[] images) {
		super(x, y, 16, 16, dim,3);
		this.images = images;
	}

	private Liquid(int x, int y, int frame, int dim, PImage[] images) {
		this(x, y, dim, images);
		this.frame = frame;
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
		d.drawImage(images[frame], x, y);
	}

	public static void declareChunk(int x, int y, int w, int h,
			List<Entity> list, int dime, PImage[] images) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				list.add(new Liquid(x + i * 16, y + j * 16, (i + j) % 4, dime,
						images));
			}
		}
	}

}
