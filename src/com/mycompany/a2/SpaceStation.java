package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedGameObject{

	// ugh, more variables
	private int BlinkRt;
	private int lightBool;
	private static final int BLINKRT_MAX = 4;
	private Random rand = new Random();
	
	// Default constructors
	public SpaceStation(int width, int height) {
		super(width, height);
		lightBool = 1;
		BlinkRt = rand.nextInt(BLINKRT_MAX + 1);
		this.setColor(ColorUtil.MAGENTA);
	}
	
	// toggles the light of the space station, because we needed a lighthouse in space
	public void toggleLight() {
		if(lightBool == 0) {
			lightBool = 1;
		}
		else if(lightBool == 1) {
			lightBool = 0;
		}
	}
	
	// We need to know where the lightho-- I mean space station's light is pointi- I mean its status
	public int getLightStatus() {
		return lightBool;
	}
	
	// Returns the lightho- I mean SpaceStations blinking rate...
	public int getBlinkRt() {
		return BlinkRt;
	}
	
	// ANOTHER SPECIAL toString() METHOD YIPEE
	public String toString() {
		String superS = super.toString();
		String regularS = "";
		regularS += "BlinkRate: " + this.getBlinkRt();
		if(lightBool == 1) {
			regularS += " Light: On";
		}
		else if(lightBool == 0) {
			regularS += " Light: Off";
		}
		return superS + regularS;
	}

	
}
