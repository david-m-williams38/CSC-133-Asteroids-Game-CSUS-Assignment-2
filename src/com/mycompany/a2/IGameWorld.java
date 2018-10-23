package com.mycompany.a2;

public interface IGameWorld {
	int getPlayLives();
	int getGameTicks();
	int getPlayScore();
	int getMissileCount();
	boolean getSound();
	void printMap();
	void setHeight(int height);
	void setWidth(int width);
}