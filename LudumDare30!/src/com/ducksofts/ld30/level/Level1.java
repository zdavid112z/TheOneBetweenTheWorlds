package com.ducksofts.ld30.level;

import com.ducksofts.ld30.entity.Liquid;
import com.ducksofts.ld30.graphics.Images;

public class Level1 extends Level {

	public Level1() {
		String[] paths = { "/images/maps/terrain11.png",
				"/images/maps/terrain12.png", "/images/maps/terrain13.png",
				"/images/maps/terrain14.png" };
		load(paths);
		gravity = 2;
	}

	@Override
	public void loadEntity() {
		String[] paths = { "/images/maps/entity11.png",
				"/images/maps/entity12.png", "/images/maps/entity13.png",
				"/images/maps/entity14.png" };
		readEntity(paths);
		Liquid.declareChunk(23 * 32 + 8, 0, 1, 84, ent, 1, Images.LAVA);
		/*ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(16 * 32, 16 * 32, 0));
		ent.add(new Shard(16 * 32, 16 * 32, 1));
		ent.add(new Shard(16 * 32, 16 * 32, 2));
		ent.add(new Shard(16 * 32, 16 * 32, 3));

		ent.add(new Shard(28 * 32, 8 * 32, 0));
		ent.add(new Shard(28 * 32, 8 * 32, 1));
		ent.add(new Shard(28 * 32, 8 * 32, 2));
		ent.add(new Shard(28 * 32, 8 * 32, 3));

		ent.add(new Shard(24 * 32, 18 * 32, 0));
		ent.add(new Shard(24 * 32, 18 * 32, 1));
		ent.add(new Shard(24 * 32, 18 * 32, 2));
		ent.add(new Shard(24 * 32, 18 * 32, 3));

		ent.add(new Shard(33 * 32, 12 * 32, 0));
		ent.add(new Shard(33 * 32, 12 * 32, 1));
		ent.add(new Shard(33 * 32, 12 * 32, 2));
		ent.add(new Shard(33 * 32, 12 * 32, 3));

		ent.add(new Shard(36 * 32, 25 * 32, 0));
		ent.add(new Shard(36 * 32, 25 * 32, 1));
		ent.add(new Shard(36 * 32, 25 * 32, 2));
		ent.add(new Shard(36 * 32, 25 * 32, 3));

		ent.add(new Shard(11 * 32, 29 * 32, 0));
		ent.add(new Shard(11 * 32, 29 * 32, 1));
		ent.add(new Shard(11 * 32, 29 * 32, 2));
		ent.add(new Shard(11 * 32, 29 * 32, 3));

		ent.add(new Shard(29 * 32, 29 * 32, 0));
		ent.add(new Shard(29 * 32, 29 * 32, 1));
		ent.add(new Shard(29 * 32, 29 * 32, 2));
		ent.add(new Shard(29 * 32, 29 * 32, 3));

		ent.add(new Shard(28 * 32, 41 * 32, 0));
		ent.add(new Shard(28 * 32, 41 * 32, 1));
		ent.add(new Shard(28 * 32, 41 * 32, 2));
		ent.add(new Shard(28 * 32, 41 * 32, 3));

		ent.add(new Shard(30 * 32, 9 * 32, 0));
		ent.add(new Shard(30 * 32, 9 * 32, 1));
		ent.add(new Shard(30 * 32, 9 * 32, 2));
		ent.add(new Shard(30 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));

		ent.add(new Shard(8 * 32, 9 * 32, 0));
		ent.add(new Shard(8 * 32, 9 * 32, 1));
		ent.add(new Shard(8 * 32, 9 * 32, 2));
		ent.add(new Shard(8 * 32, 9 * 32, 3));*/

	}
}
