package com.mycompany.a2;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MoveableGameObject{

	// Number randomizer, mathematical computation(s)
	private Random rand = new Random();
	// Size is configured within the overloaded constructor
	private int size;
	
	// Constructor for Asteroid
	public Asteroid(int width, int height) {
		// Super sends the data to upper level class
		super(width,height);
		this.setColor(ColorUtil.LTGRAY);
		size = rand.nextInt(24) + 6;
	}
	
	// Method to set the randomized size
	public void setSize(int mySize) {
		this.size = mySize;
	}
	
	// Method to get what the randomized size currently is
	public int getSize() {
		return size;
	}
	
	// toString() method
	public String toString() {
		return "Asteroid " + super.toString() + "size= " + size;
	}
	
}
