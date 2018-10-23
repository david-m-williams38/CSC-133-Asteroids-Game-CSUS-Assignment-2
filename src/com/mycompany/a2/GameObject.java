package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {

	// Set all the variables
	private int color;
	// Middle X Location
	private double xLoc = 512;
	// Middle Y Location
	private double yLoc = 384;
	// 2D Point from CN1's library
	private Point2D location;
	private Random rand = new Random();
	
	// Default constructor for GameObject()
	// This will set the location and color (NOW CHANGED TO WHITE)
	public GameObject(int height, int width)
	{
		double x = (double)rand.nextInt(width+1);
		double y = (double)rand.nextInt(height+1);
		location = new Point2D(x,y);
		this.setColor(ColorUtil.WHITE);
	}
	
	// Set the X Location
	public void setX(double x)
	{
		location.setX(x);
	}
	
	// Set the Y Location
	public void setY(double y)
	{
		location.setY(y);
	}
	

	
	// 2D Location Set
	public void setLoc(Point2D point) {
		this.location = point;
	}
	
	// Get the Location
	public Point2D getLoc() {
		return this.location;
	}
	
	// Set the color with the provided color
	public void setColor(int newColour) {
		this.color = newColour;
	}
	
	// Return the X Location
	public double getX() {
		return xLoc;
	}
	
	// Return the Y Location
	public double getY() {
		return yLoc;
	}
	
	// Return the Color
	public int getColor() {
		return color;
	}
	
	// toString() method
	public String toString(){
		double myX = Math.round( this.getX() * 10.0 ) / 10.0;
		double myY = Math.round( this.getY() * 10.0 ) / 10.0;
		String returnStr = "";
		returnStr += "Location: ( " + myX + 
				", " + myY + " ) \n" + "Color: " + " { "
				+ ColorUtil.red(getColor()) + ", "
				+ ColorUtil.green(getColor()) + ", "
				+ ColorUtil.blue(getColor()) + " } " + "\n";
		return returnStr;
	}
}
