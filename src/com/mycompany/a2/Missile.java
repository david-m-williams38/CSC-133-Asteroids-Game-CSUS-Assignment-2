package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Missile extends MoveableGameObject {

	// Set ALL them variables
	private int id;
	private int fuelLevel;
	private static final int FUEL_MAX = 10;
	private static final int MISSILE_SPEED = 1;
	
	// Missile class constructor
	public Missile(double x, double y, int speed, int direction, int ident) {
		super((int) x, (int) y);
		fuelLevel = FUEL_MAX;
		id = ident;
		super.setColor(ColorUtil.BLUE);
		if(speed + MISSILE_SPEED <= 10) {
			super.setSpeed(speed + MISSILE_SPEED);
		} else {
			super.setSpeed(11);
		}
		super.setDir(direction);
		super.setX(x);
		super.setY(y);
	}
	
	// Returns the current fuel level
	public int getFuelLevel() {
		return fuelLevel;
	}
	
	// Returns the ID of the missile object
	public int getMissileType() {
		return id;
	}
	
	// Checks the ID to see if the missile is, in fact, the player's
	public boolean getIsPlayerMissile() {
		if (id == 0)
			return true;
		else 
			return false;
	}
	
	// Sets the fuel level of the missile
	public void setFuelLevel(int fl) {
		if(fl >= 0 && fl <= FUEL_MAX) {
			fuelLevel = fl;
		}
		else {
			System.out.println("Failed to update the Missile's fuel level");
		}
	}
	
	// Error return
	public void setSpeed(int speed) {
		System.out.println("Cannot change a missile's speed!");
	}
	
	// Error return
	public void setDirection(int dir) {
		System.out.println("Cannot change a missile's direction!");
	}
	
	// Regular old toString() method, nothing too special about this one...
	public String toString() {
		String superS = super.toString();
		String regularS = "";
		if(id == 0) {
			regularS += "PS missile stats: ";
		} else {
			regularS += "NPS missile stats: ";
		}
		regularS += "Fuel Level: " + this.getFuelLevel();
		return regularS + superS;
	}
	
}
