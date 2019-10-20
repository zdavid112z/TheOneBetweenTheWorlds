package com.ducksofts.ld30.level;

public class Level2 extends Level {

	public Level2() {
		String[] paths = { "/images/maps/terrain21.png",
				"/images/maps/terrain22.png", "/images/maps/terrain23.png",
				"/images/maps/terrain24.png" };
		load(paths);
		gravity = 2;
	}

	@Override
	public void loadEntity() {
		String[] paths = { "/images/maps/entity21.png",
				"/images/maps/entity22.png", "/images/maps/entity23.png",
				"/images/maps/entity24.png" };
		readEntity(paths);
	}

}
