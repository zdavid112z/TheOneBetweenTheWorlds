package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.PImage;

public class BackElem extends Entity {

	private PImage image;

	public BackElem(int x, int y, int dim, PImage image) {
		super(x, y, 0, 0, dim, 3);
		col = false;
		this.image = image;
	}

	public void render(Display d) {
		d.drawImage(image, x, y);
	}

}
