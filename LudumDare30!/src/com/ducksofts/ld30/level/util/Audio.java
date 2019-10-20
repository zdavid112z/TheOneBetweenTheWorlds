package com.ducksofts.ld30.level.util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

	public static void load() {
		HIT_ROBOT = new Audio("/audio/hit_robot.wav");
		HIT_ANGEL = new Audio("/audio/hit_angel.wav");
		HIT_NYAN = new Audio("/audio/hit_nyan.wav");
		HIT_PLAYER = new Audio("/audio/hit.wav");
		HEAL_PLAYER = new Audio("/audio/heal.wav");
		WARP = new Audio("/audio/warp.wav");
		COIN = new Audio("/audio/coin.wav");
		DEAD = new Audio("/audio/dead.wav");
	}

	public static Audio HIT_ROBOT, HIT_ANGEL, HIT_NYAN, HIT_PLAYER,
			HEAL_PLAYER, COIN, DEAD, WARP;

	private Clip clip;

	public Audio(String path) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(this
					.getClass().getResource(path));
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		clip.setFramePosition(0);
		clip.start();
	}

	public void stop() {
		clip.stop();
	}

	public void loop(int nr) {
		clip.loop(nr);
	}

}
