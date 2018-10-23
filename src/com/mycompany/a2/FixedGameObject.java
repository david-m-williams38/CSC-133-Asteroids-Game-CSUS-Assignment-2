package com.mycompany.a2;

public class FixedGameObject extends GameObject{

	// Set all the variables
	private int id;
	private static int specificId = 0;
	
	// Default constructor
	public FixedGameObject(int width, int height) {
		// Super sends the data to upper level class
		super(width,height);
		this.id = specificId;
		specificId++;
	}
	
	// Method to set the identifier number that was provided for the method
	public void setId(int identity) {
		this.id = identity;
	}
	
	// Method to return the identifier number that was set
	public int getId() {
		return id;
	}
	
	// toString() method
	public String toString() {
		String returnStr = "";
		returnStr = super.toString() + "Space Station ID: " + this.getId();
		return returnStr;
	}
	
}
