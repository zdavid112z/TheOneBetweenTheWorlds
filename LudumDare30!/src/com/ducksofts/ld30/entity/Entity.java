package com.ducksofts.ld30.entity;

import com.ducksofts.ld30.core.Core;
import com.ducksofts.ld30.graphics.Display;
import com.ducksofts.ld30.level.util.Maths;
import com.ducksofts.ld30.level.util.Vector2;

public class Entity {

	public int x, y;
	public int w, h;
	public int cx, cy;
	public int motX, motY;

	public int z;

	public int dim = 0;
	public boolean col;

	public Entity(int x, int y, int w, int h, int dim, int z) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.z = z;
		col = false;
		this.dim = dim;
	}

	public void updateCenter() {
		cx = x + w / 2;
		cy = y + h / 2;
	}

	public void update() {
		updateCenter();
	}

	public boolean shouldAdd(int mx, int my, int ter) {
		updateCenter();
		int tx = x + mx;
		int ty = y + my;
		int tcx = cx + mx;
		int tcy = cy + my;
		for (Entity e : Core.core.display.level.ent) {
			if (e.dim != ter)
				continue;
			if (!e.col)
				continue;
			if (e.equals(this))
				continue;
			e.updateCenter();
			int dx = Math.abs(tcx - e.cx);
			int dy = Math.abs(tcy - e.cy);
			if (dx <= (w + e.w) / 2) {
				if (dy <= (h + e.h) / 2) {
					return false;
				}
			}
		}
		if (Core.core.display.level.solidAt(tx, ty, ter))
			return false;
		if (Core.core.display.level.solidAt((tx + w), ty, ter))
			return false;
		if (Core.core.display.level.solidAt(tx, (ty + h), ter))
			return false;
		if (Core.core.display.level.solidAt((tx + w), (ty + h), ter))
			return false;
		if (Core.core.display.level.solidAt((tx + w / 2), (ty), ter))
			return false;
		if (Core.core.display.level.solidAt((tx), (ty + h / 2), ter))
			return false;
		if (Core.core.display.level.solidAt((tx + w / 2), (ty + h), ter))
			return false;
		if (Core.core.display.level.solidAt((tx + w), (ty + h / 2), ter))
			return false;
		return true;
	}

	public void render(Display d) {

	}

	public boolean collides(Entity e) {
		updateCenter();
		e.updateCenter();
		if (dim != e.dim)
			return false;
		int dx = Math.abs(cx - e.cx);
		int dy = Math.abs(cy - e.cy);
		if (dx < (w + e.w) / 2) {
			if (dy < (h + e.h) / 2) {
				return true;
			}
		}
		return false;
	}

	public void attack(int xOff, int yOff, int w, int h, int damage) {
		for (Entity e : Core.core.display.level.ent) {
			if (e.equals(this))
				continue;
			if (!(e instanceof Mob))
				continue;
			if (e.dim != dim)
				continue;
			if (Maths.collide(new Vector2(cx + xOff, cy + yOff), new Vector2(w,
					h), new Vector2(e.cx, e.cy), new Vector2(e.w, e.h))) {
				((Mob) e).damage(damage);
			}
		}
	}

}
