package com.ducksofts.ld30.level;

import com.ducksofts.ld30.entity.Liquid;
import com.ducksofts.ld30.graphics.Images;

public class Level3 extends Level {

	public Level3() {
		String[] paths = { "/images/maps/terrain31.png",
				"/images/maps/terrain32.png", "/images/maps/terrain33.png",
				"/images/maps/terrain34.png" };
		load(paths);
		gravity = 2;
	}

	@Override
	public void loadEntity() {
		String[] paths = { "/images/maps/entity31.png",
				"/images/maps/entity32.png", "/images/maps/entity33.png",
				"/images/maps/entity34.png" };
		readEntity(paths);
		Liquid.declareChunk(11 * 32, 7 * 32, 2, 50, ent, 1, Images.LAVA);
		Liquid.declareChunk(16 * 32 + 8, 7 * 32, 1, 50, ent, 1, Images.LAVA);
		Liquid.declareChunk(38 * 32, 7 * 32, 4, 50, ent, 1, Images.LAVA);
		Liquid.declareChunk(20 * 32, 7 * 32, 2, 50, ent, 0, Images.WATER);
		Liquid.declareChunk(43 * 32, 7 * 32, 2, 50, ent, 0, Images.WATER);
	}

}
