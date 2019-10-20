package com.ducksofts.ld30.entity;

public class EntityReg {

	public Entity e;
	public int code;
	public int xOff, yOff;

	public EntityReg(Entity e, int code) {
		this(e, code, 0, 0);
	}

	public EntityReg(Entity e, int code, int xOff, int yOff) {
		this.e = e;
		this.code = code;
		this.xOff = xOff;
		this.yOff = yOff;
	}

}
