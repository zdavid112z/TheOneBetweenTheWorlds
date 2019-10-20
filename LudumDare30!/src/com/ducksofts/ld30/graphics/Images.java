package com.ducksofts.ld30.graphics;

public class Images {

	public static void load() {
		GRASS = new PImage("/grass.png");
		PLAYER = new PImage[14];
		PLAYER[0] = new PImage("/images/player/ri.png");
		PLAYER[1] = new PImage("/images/player/r1.png");
		PLAYER[2] = new PImage("/images/player/r2.png");
		PLAYER[3] = new PImage("/images/player/r3.png");
		PLAYER[4] = new PImage("/images/player/r4.png");
		PLAYER[5] = new PImage("/images/player/li.png");
		PLAYER[6] = new PImage("/images/player/l1.png");
		PLAYER[7] = new PImage("/images/player/l2.png");
		PLAYER[8] = new PImage("/images/player/l3.png");
		PLAYER[9] = new PImage("/images/player/l4.png");
		PLAYER[10] = new PImage("/images/player/rb.png");
		PLAYER[11] = new PImage("/images/player/lb.png");
		PLAYER[12] = new PImage("/images/player/ra.png");
		PLAYER[13] = new PImage("/images/player/la.png");
		BLINK = new PImage[8];
		BLINK[0] = new PImage("/images/blink/b0.png");
		BLINK[1] = new PImage("/images/blink/b1.png");
		BLINK[2] = new PImage("/images/blink/b2.png");
		BLINK[3] = new PImage("/images/blink/b3.png");
		BLINK[4] = new PImage("/images/blink/b4.png");
		BLINK[5] = new PImage("/images/blink/b5.png");
		BLINK[6] = new PImage("/images/blink/b6.png");
		BLINK[7] = new PImage("/images/blink/b7.png");
		BRICK = new PImage("/images/tile/brick.png");
		WALL = new PImage("/images/tile/wall.png");
		PILLAR = new PImage("/images/tile/pillar.png");
		PILLAR_BASE = new PImage("/images/tile/pillar_base.png");
		WALL2 = new PImage("/images/entity/wall2.png");
		DEMON = new PImage[2];
		DEMON[0] = new PImage("/images/entity/spec/demon1.png");
		DEMON[1] = new PImage("/images/entity/spec/demon2.png");
		ANGEL = new PImage[2];
		ANGEL[0] = new PImage("/images/entity/spec/angel1.png");
		ANGEL[1] = new PImage("/images/entity/spec/angel2.png");
		CLOUD = new PImage("/images/entity/spec/cloud.png");
		ROBOT = new PImage[9];
		ROBOT[0] = new PImage("/images/entity/robot/i.png");
		ROBOT[1] = new PImage("/images/entity/robot/r1.png");
		ROBOT[2] = new PImage("/images/entity/robot/r2.png");
		ROBOT[3] = new PImage("/images/entity/robot/r3.png");
		ROBOT[4] = new PImage("/images/entity/robot/r4.png");
		ROBOT[5] = new PImage("/images/entity/robot/l1.png");
		ROBOT[6] = new PImage("/images/entity/robot/l2.png");
		ROBOT[7] = new PImage("/images/entity/robot/l3.png");
		ROBOT[8] = new PImage("/images/entity/robot/l4.png");
		LAVA = new PImage[4];
		LAVA[0] = new PImage("/images/entity/lava/lava1.png");
		LAVA[1] = new PImage("/images/entity/lava/lava2.png");
		LAVA[2] = new PImage("/images/entity/lava/lava3.png");
		LAVA[3] = new PImage("/images/entity/lava/lava4.png");
		WATER = new PImage[4];
		WATER[0] = new PImage("/images/entity/water/water1.png");
		WATER[1] = new PImage("/images/entity/water/water2.png");
		WATER[2] = new PImage("/images/entity/water/water3.png");
		WATER[3] = new PImage("/images/entity/water/water4.png");
		CAULDRON = new PImage[4];
		CAULDRON[0] = new PImage("/images/entity/cauldron/cauldron1.png");
		CAULDRON[1] = new PImage("/images/entity/cauldron/cauldron2.png");
		CAULDRON[2] = new PImage("/images/entity/cauldron/cauldron3.png");
		CAULDRON[3] = new PImage("/images/entity/cauldron/cauldron4.png");
		ROBO = new PImage[4];
		ROBO[0] = new PImage("/images/entity/robo/robo1.png");
		ROBO[1] = new PImage("/images/entity/robo/robo2.png");
		ROBO[2] = new PImage("/images/entity/robo/robo3.png");
		ROBO[3] = new PImage("/images/entity/robo/robo4.png");
		CLOUD_BLOCK = new PImage("/images/tile/cloud.png");
		ANGEL_BLOCK = new PImage("/images/tile/angel_block.png");
		HELL_BLOCK = new PImage("/images/tile/hell_block.png");
		NETHERRACK = new PImage("/images/tile/netherrack.png");
		FACTORY_BLOCK = new PImage("/images/tile/tech_block.png");
		CANDY_GRASS = new PImage("/images/tile/candy_grass.png");
		NYAN = new PImage[4];
		NYAN[0] = new PImage("/images/entity/nyan/r1.png");
		NYAN[1] = new PImage("/images/entity/nyan/r2.png");
		NYAN[2] = new PImage("/images/entity/nyan/l1.png");
		NYAN[3] = new PImage("/images/entity/nyan/l2.png");
		HARP = new PImage("/images/entity/spec/harp.png");
		LOLLIPOP = new PImage("/images/entity/spec/lollipop.png");
		SHARD = new PImage("/images/entity/spec/shard.png");
		RAINBOW_TRAIL = new PImage("/images/entity/rainbow/trail.png");
		RAINBOW_SMALL = new PImage("/images/entity/rainbow/simple.png");
		RAINBOW_BIG = new PImage("/images/entity/rainbow/big.png");
		BACK = new PImage[4];
		BACK[0] = new PImage("/images/menu/back1.png");
		BACK[1] = new PImage("/images/menu/back2.png");
		BACK[2] = new PImage("/images/menu/back3.png");
		BACK[3] = new PImage("/images/menu/back4.png");
		START_N = new PImage("/images/menu/startn.png");
		START_H = new PImage("/images/menu/starth.png");
		HELP_N = new PImage("/images/menu/helpn.png");
		HELP_H = new PImage("/images/menu/helph.png");
		EXIT_N = new PImage("/images/menu/exitn.png");
		EXIT_H = new PImage("/images/menu/exith.png");
		HELP = new PImage("/images/menu/help.png");
		BAR = new PImage[5];
		BAR[0] = new PImage("/images/menu/bar0.png");
		BAR[1] = new PImage("/images/menu/bar1.png");
		BAR[2] = new PImage("/images/menu/bar2.png");
		BAR[3] = new PImage("/images/menu/bar3.png");
		BAR[4] = new PImage("/images/menu/bar4.png");
		CANDYLAND = new PImage("/images/menu/candyland.png");
		TECHWORLD = new PImage("/images/menu/techworld.png");
		NEWLEVEL_N = new PImage("/images/menu/leveln.png");
		NEWLEVEL_H = new PImage("/images/menu/levelh.png");
		SPEED = new PImage("/images/menu/speed.png");
		POWER = new PImage("/images/menu/power.png");
		HEALTH = new PImage("/images/menu/health.png");
		GRAY = new PImage("/images/tile/gray.png");
		WHITE = new PImage("/images/tile/white.png");
		RED = new PImage("/images/tile/red.png");
		CANDY = new PImage("/images/entity/spec/candy.png");
		PAUSED = new PImage("/images/menu/paused.png");
	}

	public static PImage[] PLAYER, BLINK, DEMON, ANGEL, ROBOT, LAVA, WATER,
			CAULDRON, ROBO, NYAN, BACK, BAR;
	public static PImage GRASS, BRICK, WALL, PILLAR, PILLAR_BASE, WALL2, CLOUD,
			CLOUD_BLOCK, ANGEL_BLOCK, HELL_BLOCK, NETHERRACK, FACTORY_BLOCK,
			CANDY_GRASS, WHITE, GRAY, RED, HARP, LOLLIPOP, SHARD,
			RAINBOW_TRAIL, RAINBOW_SMALL, RAINBOW_BIG, START_N, START_H,
			HELP_N, HELP_H, EXIT_N, EXIT_H, HELP, CANDYLAND, TECHWORLD,
			NEWLEVEL_N, NEWLEVEL_H, SPEED, HEALTH, POWER, CANDY, PAUSED;

}
