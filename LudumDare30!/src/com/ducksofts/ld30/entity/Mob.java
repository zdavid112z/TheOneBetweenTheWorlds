package com.ducksofts.ld30.entity;

public interface Mob {
	
	public int getHealth();
	public void damage(int amount);
	public void die();
}
