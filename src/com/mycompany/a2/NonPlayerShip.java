package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class NonPlayerShip extends Ship{
	
	// Setting variables
	private int size;
	private final static int XXL = 20;
	private final static int OOMPA_LOOMPA_SIZE = 10;
	private final static int MISSILE_MAX = 2;
	private NPSMissileLauncher ml;
	private int missileCount;
	private Random rand = new Random();
	
	// Constructor
	public NonPlayerShip(int width, int height){
		super(width, height);
		missileCount = MISSILE_MAX;
		size = rand.nextInt(XXL - OOMPA_LOOMPA_SIZE) + OOMPA_LOOMPA_SIZE;
		ml = 
				new NPSMissileLauncher(
						super.getDir(), 
						super.getX(), 
						super.getY());
		super.setColor(ColorUtil.MAGENTA);
	}
	
	// Method that returns the randomized size
	public int getSize() {
		return size;
	}
	
	// FIRE THAT CANNON
	public Missile fire() {
		missileCount -= 1;
		return ml.fire(this.getSpeed());
	}
	
	// Returns the amount of puny missiles
	public int getMissileCount() {
		return missileCount;
	}
	
	// Gets the NPS's's's Missile Launcher
	public NPSMissileLauncher getMissileLauncher() {
		return ml;
	}
	
	// Sets the number of missiles for the chosen NPS
	public void setMissileCount(int x) {
		missileCount = x;
	}
	
	// RETURNS THE MAXIMUM NUMBER OF MISSILES ALLOWED
	public int getMaxMissiles() {
		return MISSILE_MAX;
	}
	
	// It is a toString(), what'd you expect?
	public String toString() {
		String NPS = "NPS: " + super.toString() + "size= " + getSize();
		String NPSMissileLauncher = this.getMissileLauncher().toString();
		return NPS + NPSMissileLauncher;
	}
	
}
