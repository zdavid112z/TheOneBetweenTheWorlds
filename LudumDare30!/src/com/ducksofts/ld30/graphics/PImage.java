package com.ducksofts.ld30.graphics;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class PImage {

	public int[] pixels;
	public int w, h;

	public PImage(String path) {
		try {
			BufferedImage image = ImageIO.read(this.getClass()
					.getResource(path));
			w = image.getWidth();
			h = image.getHeight();
			pixels = new int[w * h];
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (Exception e) {
			System.err.println("Could not load " + path);
		}
	}
}
