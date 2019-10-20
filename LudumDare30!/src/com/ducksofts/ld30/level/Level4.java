package com.ducksofts.ld30.level;

import com.ducksofts.ld30.entity.Liquid;
import com.ducksofts.ld30.graphics.Images;

public class Level4 extends Level {

	public Level4() {
		String[] paths = { "/images/maps/terrain41.png",
				"/images/maps/terrain42.png", "/images/maps/terrain43.png",
				"/images/maps/terrain44.png" };
		load(paths);
		gravity = 2;
	}

	@Override
	public void loadEntity() {
		String[] paths = { "/images/maps/entity41.png",
				"/images/maps/entity42.png", "/images/maps/entity43.png",
				"/images/maps/entity44.png" };
		readEntity(paths);
		Liquid.declareChunk(11 * 32, 7 * 32, 2, 50, ent, 1, Images.LAVA);
		Liquid.declareChunk(16 * 32 + 8, 7 * 32, 1, 50, ent, 1, Images.LAVA);
		Liquid.declareChunk(38 * 32, 7 * 32, 4, 50, ent, 1, Images.LAVA);
		Liquid.declareChunk(20 * 32, 7 * 32, 2, 50, ent, 0, Images.WATER);
		Liquid.declareChunk(43 * 32, 7 * 32, 2, 50, ent, 0, Images.WATER);
	}
}
