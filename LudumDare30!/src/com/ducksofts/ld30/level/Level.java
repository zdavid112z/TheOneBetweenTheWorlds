package com.ducksofts.ld30.level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.core.GameState;
import com.ducksofts.ld30.entity.Angel;
import com.ducksofts.ld30.entity.Candy;
import com.ducksofts.ld30.entity.Cauldron;
import com.ducksofts.ld30.entity.Cloud;
import com.ducksofts.ld30.entity.Devil;
import com.ducksofts.ld30.entity.Entity;
import com.ducksofts.ld30.entity.EntityReg;
import com.ducksofts.ld30.entity.Harp;
import com.ducksofts.ld30.entity.Lava;
import com.ducksofts.ld30.entity.Lollipop;
import com.ducksofts.ld30.entity.Nyan;
import com.ducksofts.ld30.entity.Player;
import com.ducksofts.ld30.entity.Robo;
import com.ducksofts.ld30.entity.Robot;
import com.ducksofts.ld30.entity.Shard;
import com.ducksofts.ld30.entity.Water;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.graphics.Images;
import com.ducksofts.ld30.graphics.PImage;
import com.ducksofts.ld30.level.tile.Tile;
import com.ducksofts.ld30.level.util.Audio;

public abstract class Level {

	public static Comparator<Entity> comp = new Comparator<Entity>() {
		public int compare(Entity e1, Entity e2) {
			if (e1.z > e2.z)
				return -1;
			if (e1.z == e2.z)
				return 0;
			return 1;
		}
	};

	public List<Entity> ent = new ArrayList<Entity>();

	public static List<EntityReg> reg = new ArrayList<EntityReg>();

	public Player player;

	private int timerr = 0;
	private int duration = Core.UPS * 60;
	private int totalTime;

	public PImage[] terrain;
	public int curTer;
	public int gravity;

	protected int timer = 0;
	protected int changeFrame = 5;
	protected int frame;
	protected boolean blink = false;

	public abstract void loadEntity();

	public int getTime() {
		return (totalTime - timerr) / Core.UPS;
	}

	public static void register() {
		reg.add(new EntityReg(new Player(0, 0, 0), 0xffFF1500));
		reg.add(new EntityReg(new Cauldron(0, 0, 0), 0xffA00200, 0, 8));
		reg.add(new EntityReg(new Cloud(0, 0, 0), 0xffC0C0C0));
		reg.add(new EntityReg(new Devil(0, 0, 0), 0xffBF003C));
		reg.add(new EntityReg(new Angel(0, 0, 0), 0xffD8D8D8));
		reg.add(new EntityReg(new Water(0, 0, 0), 0xff2000D8));
		reg.add(new EntityReg(new Lava(0, 0, 0), 0xffD84100));
		reg.add(new EntityReg(new Nyan(0, 0, 0), 0xffFF00D0));
		reg.add(new EntityReg(new Robo(0, 0, 0), 0xff00FFFF, 0, -16));
		reg.add(new EntityReg(new Robot(0, 0, 0), 0xff0090FF));
		reg.add(new EntityReg(new Shard(0, 0, 0), 0xff00FF48));
		reg.add(new EntityReg(new Candy(0, 0, 0), 0xffFFC2C3));
		reg.add(new EntityReg(new Lollipop(0, 0, 0), 0xffFF69C3, 0, -16));
		reg.add(new EntityReg(new Harp(0, 0, 0), 0xffFFF959, 0, -16));
	}

	public void readEntity(String[] paths) {
		PImage[] entity = new PImage[paths.length];
		for (int i = 0; i < paths.length; i++) {
			entity[i] = new PImage(paths[i]);
			for (int j = 0; j < entity[i].w; j++) {
				for (int k = 0; k < entity[i].h; k++) {
					for (EntityReg e : reg) {
						if (entity[i].pixels[j + k * entity[i].w] == e.code) {
							try {
								ent.add((Entity) e.e
										.getClass()
										.getConstructor(int.class, int.class,
												int.class)
										.newInstance(j * 32 + e.xOff,
												k * 32 + e.yOff, i));
								if (e.e instanceof Player) {
									player = (Player) ent.get(ent.size() - 1);
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			}
		}

	}

	public void load(String[] paths) {
		terrain = new PImage[paths.length];
		for (int i = 0; i < paths.length; i++) {
			terrain[i] = new PImage(paths[i]);
		}
		curTer = 0;
		decode();
		loadEntity();
		totalTime = duration * 2 + ((Player.hasTech) ? duration : 0)
				+ ((Player.hasCandy) ? duration : 0);
	}

	public void decode() {
		for (int t = 0; t < terrain.length; t++) {
			for (int j = 0; j < terrain[t].pixels.length; j++) {
				for (int i = 0; i < Tile.tiles.size(); i++) {
					if (terrain[t].pixels[j] == Tile.tiles.get(i).code) {
						terrain[t].pixels[j] = i;
					}
				}
			}
		}
	}

	public boolean solidAt(int dx, int dy, int ter) {
		int x = dx / 32;
		int y = dy / 32;
		if (x < 0)
			return true;
		if (x >= terrain[ter].w)
			return true;
		if (y >= terrain[ter].h)
			return true;
		if (y < 0)
			return true;
		if (Tile.tiles.get(terrain[ter].pixels[x + y * terrain[ter].w]).image == Images.CLOUD_BLOCK) {
			if (y * 32 + 12 > dy)
				return true;
			else
				return false;
		}
		return Tile.tiles.get(terrain[ter].pixels[x + y * terrain[ter].w]).solid;
	}

	public void update() {
		Collections.sort(ent, comp);
		for (int i = 0; i < ent.size(); i++) {
			if (ent.get(i).dim == curTer)
				ent.get(i).update();
		}
		if (blink) {
			timer++;
			if (timer == changeFrame) {
				timer = 0;
				frame++;
				if (frame == 8)
					blink = false;
			}
		}
		timerr++;
		if (timerr == totalTime) {
			Core.core.display.gs = GameState.UPGRADES;
		}
	}

	public void render(Display d) {
		for (int i = 0; i < terrain[curTer].w; i++) {
			for (int j = 0; j < terrain[curTer].h; j++) {
				Tile.tiles.get(
						terrain[curTer].pixels[i + j * terrain[curTer].w])
						.renderAt(d, i, j);
			}
		}
		for (int i = 0; i < ent.size(); i++) {
			if (ent.get(i).dim == curTer)
				ent.get(i).render(d);
		}
		if (blink) {
			d.drawGUI(Images.BLINK[frame], 0, 0);
		}
	}

	public void clear() {
		ent.clear();
	}

	public void blink() {
		Audio.WARP.play();
		blink = true;
		timer = 0;
		frame = 0;
	}

	public void reset() {
		timerr = 0;
		ent.clear();
	}

}
