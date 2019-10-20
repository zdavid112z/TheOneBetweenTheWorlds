package com.ducksofts.ld30.level.util;

public class Maths {

	public static float dist(float sx, float sy, float dx, float dy) {
		float x = Math.abs(sx - dx);
		float y = Math.abs(sy - dy);
		return (float) Math.sqrt(x * x + y * y);
	}

	public static boolean inside(float x, float y, float sx, float sy, float w,
			float h) {
		if (x > sx)
			if (x < sx + w)
				if (y > sy)
					if (y < sy + h)
						return true;
		return false;
	}

	public static Vector2 getMots(float sx, float sy, float dx, float dy) {
		double x = dx - sx;
		double y = dy - sy;
		double dir = Math.atan2(y, x);
		x = Math.cos(dir);
		y = Math.sin(dir);
		return new Vector2((float) x, (float) y);
	}

	public static boolean collide(Vector2 p1, Vector2 s1, Vector2 p2, Vector2 s2) {
		float dx = Math.abs(p1.x - p2.x);
		float dy = Math.abs(p1.y - p2.y);
		if (dx < (s1.x + s2.x) / 2)
			if (dy < (s1.y + s2.y) / 2)
				return true;
		return false;
	}

}
