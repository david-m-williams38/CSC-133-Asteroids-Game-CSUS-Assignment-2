package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {

	private GameWorld gw;

    GameWorldProxy(GameWorld gw) {
        this.gw = gw;
    }
    
	public IIterator getIterator() {
		return gw.getIterator();	
	}
	
	public int getPlayScore() {
		return gw.getPlayScore();
	}

	public int getPlayLives() {
		return gw.getPlayLives();
	}

	public int getMissileCount() {
		return ((IGameWorld) gw).getMissileCount();
	}

	public int getGameTicks() {
		return gw.getGameTicks();
	}
	
	public boolean getSound() {
		return gw.getSound();
	}
	
	public void printMap() {
		gw.printMap();
	}
	
	public void setWidth(int width) {
		gw.setWidth(width);
	}
	
	public void setHeight(int height) {
		gw.setHeight(height);
	}
	
}