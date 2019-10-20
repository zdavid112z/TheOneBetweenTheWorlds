package com.ducksofts.ld30.level.tile;

import java.util.ArrayList;
import java.util.List;

import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;
import com.ducksofts.ld30.graphics.PImage;

public class Tile {

	public static List<Tile> tiles = new ArrayList<Tile>();

	public static void init() {
		tiles.add(new Tile(0xff00ff00, Images.GRASS, false));
		tiles.add(new Tile(0xffFFA100, Images.BRICK, true));
		tiles.add(new Tile(0xffFFE800, Images.WALL, false));
		tiles.add(new Tile(0xffFFC900, Images.PILLAR, false));
		tiles.add(new Tile(0xffFFBE00, Images.PILLAR_BASE, false));
		tiles.add(new Tile(0xff00FF04, Images.CANDY_GRASS, true));
		tiles.add(new Tile(0xffFFFCF9, Images.CLOUD_BLOCK, true));
		tiles.add(new Tile(0xffFFEF7A, Images.ANGEL_BLOCK, true));
		tiles.add(new Tile(0xffCE0300, Images.HELL_BLOCK, true));
		tiles.add(new Tile(0xffFF0000, Images.NETHERRACK, true));
		tiles.add(new Tile(0xff0000FF, Images.FACTORY_BLOCK, true));
		tiles.add(new Tile(0xff808080, Images.WHITE, false));
		tiles.add(new Tile(0xff800000, Images.RED, false));
		tiles.add(new Tile(0xff303030, Images.GRAY, false));
		tiles.add(new Tile(0xff4C4C4C, Images.WHITE, true));
		tiles.add(new Tile(0xff440200, Images.RED, true));
		tiles.add(new Tile(0xff212121, Images.GRAY, true));
	}

	public int code;
	public PImage image;
	public boolean solid;

	public Tile(int code, PImage image, boolean solid) {
		this.code = code;
		this.image = image;
		this.solid = solid;
	}

	public void renderAt(Display d, int x, int y) {
		d.drawImage(image, x * 32, y * 32);
	}

}
