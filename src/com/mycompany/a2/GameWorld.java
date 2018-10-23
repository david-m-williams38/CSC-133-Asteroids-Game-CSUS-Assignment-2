package com.mycompany.a2;

import java.util.Random;
import java.util.Observable;

public class GameWorld extends Observable implements IGameWorld {

	// Set the variables
	Random rand = new Random();
	private GameObjectCollection gameObjs;
	private int lives;
	private final int TURN_AMOUNT = 5;
	private static final double WORLD_HEIGHT = 768.0;
	private static final double WORLD_WIDTH = 1024.0;
	private int score;
	private int gameTicks = 0;
	Boolean doesPSExist;
	private boolean soundStatus;
	private int w;
	private int h;

	// Will this work??
	public int getMissileCount() {
		IIterator iterator = getIterator();
		int missileCount = -1;
		for (int i = 0; i < iterator.size(); i++) {
			if (iterator.elementAt(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) iterator.elementAt(i);
				missileCount = ps.getMissileCount();
			}
		}
		return missileCount;
	}
	
	// initialization method
	public void init(int width, int height) {
		gameObjs = new GameObjectCollection();
		lives = 3;
		score = 0;
		gameTicks = 0;
		soundStatus = false;
		this.setWidth(width);
		this.setHeight(height);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public IIterator getIterator() {
		return gameObjs.getIterator();
	}
	
	public int getElapsedTime() {
		return gameTicks;
	}
	
	public boolean getSound() {
		return soundStatus;
	}
	
	public boolean setSound() {
		if (soundStatus == true)
			soundStatus = false;
		else
			soundStatus = true;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		return true;
	}
	
	// Create a new NPS in the game
	public void addNPS() {
		NonPlayerShip nps = new NonPlayerShip(w, h);
		gameObjs.add(nps);
		System.out.println("An NPS has been created.");
		System.out.println(nps);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	
	// Create a new PS in the game
	// This also has redundant checks within this method/function
	public void addPS() {
		boolean shipCreated = false;
		IIterator it = getIterator();
		while(it.hasNext()) {
			if(it.getNext() instanceof PlayerShip) {
				shipCreated = true;
				break;
			}
		}
		if(!shipCreated) {
			PlayerShip myPS = new PlayerShip(w, h);
			gameObjs.add(myPS);
			System.out.println("A new player ship has been created");
		}
		else {
			System.out.println("Cannot create more than one player ship");
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// Return how many ticket have passed in the game
	public int getGameTicks() {
		return gameTicks;
	}
	
	// Add one more tick to the game, increasing the time in the game
	// Ticks are the main function of time tracking within the game
	// This will be critical later....
	public void incrementGameTicks() {
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		gameTicks++;
	}
	
	// Checks to see if the item is a PS
	public Boolean isPS(int index) {
		IIterator it = getIterator();
		Boolean isAPS = false;
		if(it.elementAt(index) instanceof PlayerShip)
			isAPS = true;
		return isAPS;
	}
	
	// Returns if it is anananaonymous NPS
	public Boolean isNonPlayerShip(int index) {
		Boolean isANPS = false;
		IIterator it = getIterator();
		if(it.elementAt(index) instanceof NonPlayerShip)
			isANPS = true;
		return isANPS;
	}
	
	// ERROR METHOD
	public void PrintNoPS() {
		System.out.println("Error: PS doesn't exist! Did you create one?");
	}
	
	// ERROR METHOD
	public void PrintNoNPS() {
		System.out.println("Error: NPS doesn't exist! Did you create one?");
	}
	
	// RETURNS THE PLAYER LIVES
	public int getPlayLives() {
		return lives;
	}
	
	// Gets the player score, IT BETTER BE A HIGH SCORE
	public int getPlayScore() {
		return score;
	}
	
	// Sets the player score, pathetic little bitty points
	public void setPlayScore(int x) {
		score = x;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// Sets the player lives
	public void setPlayLives(int x) {
		lives = x;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// adds a new asteroid, they still haven't weaponized themselves yet...
	public void addAsteroid() {
		Asteroid asteroid = new Asteroid(w, h);
		gameObjs.add(asteroid);
		System.out.println("A new ASTEROID has been created.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// Adds a space station, this should really be there, they can't live without their lighthouse
	public void addStation() {
		SpaceStation ss = new SpaceStation(this.w, this.h);
		gameObjs.add(ss);
		System.out.println("A new SS has been created.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// FASTER SPEED
	public void increasePSS() {
		IIterator it = getIterator();

		for(int i = 0; i < it.size(); i++) {
			if(it.elementAt(i) instanceof PlayerShip) {
				PlayerShip myShip = (PlayerShip) it.elementAt(i);
				myShip.setSpeed(myShip.getSpeed() + 1);
				System.out.println("Increased PS speed");
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// CLOSER TO TORTOISE SPEED
	public void decreasePSS() {
		IIterator it = getIterator();

		for(int i = 0; i < it.size(); i++) {
			if(it.elementAt(i) instanceof PlayerShip) {
				PlayerShip myShip = (PlayerShip) it.elementAt(i);
				myShip.setSpeed(myShip.getSpeed() - 1);
				System.out.println("Decreased PS speed");
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	// CHA CHA SLIDE TO THE LEFT
	public void turnLeft() {
		Boolean playerBool = false;
		IIterator it = getIterator();

		for(int i = 0; i <it.size() && !playerBool;i++) {
			if (it.elementAt(i) instanceof ISteerable) {
				playerBool = isPS(i);
				if(playerBool) {
					PlayerShip ps = (PlayerShip) it.elementAt(i);
					if (ps.getDir() == 0)
						ps.setDir(360 - TURN_AMOUNT);
					else
						ps.setDir(ps.getDir() - TURN_AMOUNT);
					System.out.println("PS turned " + TURN_AMOUNT + " degrees counter-clockwise. dir = " + ps.getDir());
				}
			}
		}
		if(!playerBool)
			PrintNoPS();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// CHA CHA SLIDE TO THE RIGHT
	public void turnRight() {
		Boolean playerBool = false;
		IIterator it = getIterator();

		for(int i = 0; i <it.size() && !playerBool;i++) {
			if(it.elementAt(i) instanceof ISteerable) {
				playerBool = isPS(i);
				if(playerBool) {
					PlayerShip ps = (PlayerShip) it.elementAt(i);
					if ((ps.getDir() + TURN_AMOUNT) == 360)
						ps.setDir(0);
					else
						ps.setDir(ps.getDir() + TURN_AMOUNT);
					System.out.println("PS turned " + TURN_AMOUNT + " degrees clockwise. dir = " + ps.getDir());
				}
			}
		}
		if(!playerBool)
			PrintNoPS();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// UNDO YOUR CHA CHA SLDE BY MOVING THE MISSILE LAUNCHER
	public void turnPSML() {
		Boolean playerBool = false;
		IIterator it = getIterator();

		for(int i = 0; i <it.size() && !playerBool;i++) {
			if(it.elementAt(i) instanceof ISteerable) {
				playerBool = isPS(i);
				if(playerBool) {
					PlayerShip ps = (PlayerShip) it.elementAt(i);
					if (ps.getMissileLauncher().getDir() == 0)
						ps.getMissileLauncher().setDir(360 - TURN_AMOUNT);
					else
						ps.getMissileLauncher().setDir(ps.getMissileLauncher().getDir() - TURN_AMOUNT);
					System.out.println("MISSILELAUNCHER turned " + TURN_AMOUNT + " degrees counter-clockwise. dir = " + ps.getMissileLauncher().getDir());
				}
			}
		}
		if(!playerBool)
			PrintNoPS();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	// FIRING MY LA- MISSILE
	public void firePSMissile() {
		IIterator it = getIterator();

		for(int i = 0; i < it.size(); i++) {
			if(it.elementAt(i) instanceof PlayerShip) {
				PlayerShip myShip = (PlayerShip) it.elementAt(i);
				if(myShip.getMissileCount() > 0) {
					Missile newMissile = myShip.fire();
					gameObjs.add(newMissile);
				}
				else {
					System.out.println("You shot all of your missiles already, get your resupply at the Space Station");
				}
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	// Fire an NPS missile
	public void fireNPSMissile() {
		IIterator it = getIterator();

		for(int i = 0; i < it.size(); i++) {
			if(it.elementAt(i) instanceof NonPlayerShip) {
				NonPlayerShip aShip = (NonPlayerShip) it.elementAt(i);
				if(aShip.getMissileCount() > 0) {
					Missile newMissile = aShip.fire();
					gameObjs.add(newMissile);
				}
				else
					System.out.println("NPS is out of missiles");
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// STAR TREK JUMP TO THE, same dimension?
	public void jump() {
		Boolean playerBool = false; 
		Boolean psBool = false; 
		IIterator it = getIterator();

		for(int i = 0; i <it.size();i++) {
			playerBool = isPS(i);
			if(playerBool) {
				psBool = true;
				PlayerShip ps = (PlayerShip) it.elementAt(i);
				ps.setX(WORLD_WIDTH/2);
				ps.setY(WORLD_HEIGHT/2);
				System.out.println("PS jumped through hyperspace!");
			}
		}
		if (!psBool)
			PrintNoPS();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	// SUPPLY UP
	public void newSupply() {
		Boolean playerBool = false; 
		Boolean psBool = false; 
		IIterator it = getIterator();

		for(int i = 0; i <it.size();i++) {
			playerBool = isPS(i);
			if(playerBool) {
				psBool = true;
				PlayerShip ps = (PlayerShip) it.elementAt(i);
				ps.restockMissiles();
				System.out.println("PS has successfully resupplied! You now have the maximum number of missiles again!");
			}
		}
		if (!psBool)
			PrintNoPS();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	// Destroyed
	public void removeMissileAsteroid() {
		Boolean asteroidBool = false;
		Boolean missileBool = false;
		Missile ms = null;
		Asteroid ast = null;
		IIterator it = getIterator();

		for(int i =0; i < it.size() && (!asteroidBool || !missileBool); i++) {
			if ((it.elementAt(i) instanceof Asteroid) && !asteroidBool) {
				ast = (Asteroid) it.elementAt(i);
				asteroidBool = true;	
			}
			if ((it.elementAt(i) instanceof Missile) && !missileBool) {
				ms = (Missile) it.elementAt(i);
				if (ms.getIsPlayerMissile() == true) {
					missileBool = true;
				}
			}			
		}
		if(asteroidBool && missileBool) {
			gameObjs.remove(ast);
			gameObjs.remove(ms);
			this.setPlayScore(this.getPlayScore() + 10);
			System.out.println("PS missile destroyed an asteroid! Your score increased by 10.");
		}
		else
			System.out.println("Error: Either an asteroid or PS missile doesn't exist");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	

	// Destroyed
	public void removeMissileNPS() {
		Boolean npsBool = false;
		Boolean missileBool = false;
		Missile ms = null;
		NonPlayerShip nps = null;
		IIterator it = getIterator();

		for(int i =0; i < it.size() && (!npsBool || !missileBool); i++) {
			if ((it.elementAt(i) instanceof NonPlayerShip) && !npsBool) {
				nps = (NonPlayerShip) it.elementAt(i);
				npsBool = true;	
			}
			if ((it.elementAt(i) instanceof Missile) && !missileBool) {
				ms = (Missile) it.elementAt(i);
				if (ms.getIsPlayerMissile() == true) {
					missileBool = true;
				}
			}			
		}
		if(npsBool && missileBool) {
			gameObjs.remove(nps);
			gameObjs.remove(ms);
			this.setPlayScore(this.getPlayScore() + 50);
			System.out.println("PS missile destroyed a NPS! Player score increased by 50");
		}
		else
			System.out.println("Error: Either NPS or PS Missile doesn't exist");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	// Destroyed
	public void removeMissilePS() {
		Boolean psExists = false;
		Boolean missileBool = false;
		Missile ms = null;
		PlayerShip ps = null;
		IIterator it = getIterator();

		for(int i =0; i < it.size() && (!psExists || !missileBool); i++) {
			if ((it.elementAt(i) instanceof PlayerShip) && !psExists) {
				ps = (PlayerShip) it.elementAt(i);
				psExists = true;	
			}
			if ((it.elementAt(i) instanceof Missile) && !missileBool) {
				ms = (Missile) it.elementAt(i);
				if (ms.getIsPlayerMissile() == false) {
					missileBool = true;
				}
			}
		}
		if(psExists && missileBool) {
			gameObjs.remove(ps);
			gameObjs.remove(ms);
			if (this.getPlayLives() != 0) {
				this.setPlayLives(this.getPlayLives() - 1); 
				System.out.println("NPS missile destroyed a PS! You lost a life!");
			}
		} else
			System.out.println("Error: Either PS or NPS missile doesn't exist");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	// Destroyed
	public void removePSAsteroid() {
		Boolean psExists = false;
		Boolean asteroidBool = false;
		PlayerShip ps = null;
		Asteroid ast = null;
		IIterator it = getIterator();

		for(int i =0; i < it.size() && (!psExists || !asteroidBool); i++) {
			if ((it.elementAt(i) instanceof PlayerShip) && !psExists) {
				ps = (PlayerShip) it.elementAt(i);
				psExists = true;	
			}
			if ((it.elementAt(i) instanceof Asteroid) && !asteroidBool) {
				ast = (Asteroid) it.elementAt(i);
				asteroidBool = true;
			}
		}
		if(psExists && asteroidBool) {
			gameObjs.remove(ps);
			gameObjs.remove(ast);
			if (this.getPlayLives() != 0) {
				this.setPlayLives(this.getPlayLives() - 1); 
				System.out.println("PS crashed into an asteroid! You lost a life!");
			}
		}
		else
			System.out.println("Error: Either PS or an asteroid doesn't exist");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// Destroyed
	public void removeNpsPs() {
		Boolean psExists = false;
		Boolean npsBool = false;
		PlayerShip ps = null;
		NonPlayerShip nps = null;
		IIterator it = getIterator();

		for(int i =0; i < it.size() && (!psExists || !npsBool); i++) {
			if ((it.elementAt(i) instanceof PlayerShip) && !psExists) {
				ps = (PlayerShip) it.elementAt(i);
				psExists = true;	
			}
			if ((it.elementAt(i) instanceof NonPlayerShip) && !npsBool) {
				nps = (NonPlayerShip) it.elementAt(i);
				npsBool = true;
			}
		}
		if(psExists && npsBool) {
			gameObjs.remove(ps);
			gameObjs.remove(nps);
			if (this.getPlayLives() != 0) {
				this.setPlayLives(this.getPlayLives() - 1); 
				System.out.println("PS crashed into an NPS! You lost a life!");
			}	
		}
		else
			System.out.println("Error: Either PS or NPS doesn't exist");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// Destroyed
	public void removeTwoAsteroids() {
		Boolean asteroid1Exists = false;
		Boolean asteroid2Exists = false;
		Asteroid ast1 = null;
		Asteroid ast2 = null;
		int ast1index = -1;
		IIterator it = getIterator();

		for(int i =0; i < it.size() && (!asteroid1Exists || !asteroid2Exists); i++) {
			if ((it.elementAt(i) instanceof Asteroid) && !asteroid1Exists) {
				ast1 = (Asteroid) it.elementAt(i);
				ast1index = i;	
				asteroid1Exists= true;	
			}
			if ((it.elementAt(i) instanceof Asteroid) && !asteroid2Exists && !(ast1index == i )) {
				ast2 = (Asteroid) it.elementAt(i);
				asteroid2Exists = true;
			}
		}
		if(asteroid1Exists && asteroid2Exists) {
			gameObjs.remove(ast1);
			gameObjs.remove(ast2);
			System.out.println("Two asteroids collided with each other and were destroyed!");
		}
		else
			System.out.println("Error: A minimum of 2 Asteroids must exist");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// Destroyed
	public void removeAsteroidNPS() {
		Boolean astExists = false;
		Boolean npsBool = false;
		Asteroid ast = null;
		NonPlayerShip nps = null;
		IIterator it = getIterator();

		for(int i =0; i < it.size() && (!astExists || !npsBool); i++) {
			if ((it.elementAt(i) instanceof Asteroid) && !astExists) {
				ast = (Asteroid) it.elementAt(i);
				astExists = true;	
			}
			if ((it.elementAt(i) instanceof NonPlayerShip) && !npsBool) {
				nps = (NonPlayerShip) it.elementAt(i);
				npsBool = true;
			}
		}
		if(astExists && npsBool) {
			gameObjs.remove(ast);
			gameObjs.remove(nps);
			System.out.println("An asteroid collided with an NPS! Both were destroyed horribly!");
		}
		else
			System.out.println("Error: Either an asteroid or an NPS doesn't exist");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// GAME TIME TRACKER, TICK TICK BOOM
	public void tick() {
		incrementGameTicks();
		System.out.println("Game ticks have been incremented by one. Time is now: " + gameTicks);
		IIterator it = getIterator();

		for(int i =0; i < it.size(); i++) {
			if ((it.elementAt(i) instanceof IMoveable)) {
				IMoveable mObj = (IMoveable) it.elementAt(i);
				mObj.move();
				double shift;
				MoveableGameObject mv = (MoveableGameObject) mObj;
				if (mv.getX() > WORLD_WIDTH) {
					shift =  mv.getX() - WORLD_WIDTH;
					mv.setX(shift); 
				}
				else if (mv.getX() < 0) {
					shift = WORLD_WIDTH - Math.abs(mv.getX()); 
					mv.setX(shift);
				}
				if (mv.getY() > WORLD_HEIGHT) {
					shift = mv.getY() - WORLD_HEIGHT;
					mv.setY(shift); 
				}
				else if (mv.getY() < 0) {
					shift = WORLD_HEIGHT - Math.abs(mv.getY());
					mv.setY(shift);
				}
				if (it.elementAt(i) instanceof PlayerShip) {
					PlayerShip ps = (PlayerShip) it.elementAt(i);
					ps.getMissileLauncher().setLoc(ps.getLoc()); 
					ps.getMissileLauncher().setSpeed(ps.getSpeed()); 
				}
				if (it.elementAt(i) instanceof NonPlayerShip) {
					NonPlayerShip nps = (NonPlayerShip) it.elementAt(i);
					nps.getMissileLauncher().setLoc(nps.getLoc()); 
					nps.getMissileLauncher().setSpeed(nps.getSpeed()); 
				}
			}
			else if ((it.elementAt(i) instanceof SpaceStation)) {
				SpaceStation station = (SpaceStation) it.elementAt(i);
				if(station.getBlinkRt() == 0) {
					station.toggleLight();
				}
				else if(gameTicks % station.getBlinkRt() == 0) {
					station.toggleLight();
				}
			}
		}
		for (int i = 0; i < it.size(); i++) {
			if (it.elementAt(i) instanceof Missile) {
				Missile ms = (Missile) it.elementAt(i);
				ms.setFuelLevel(ms.getFuelLevel() - 1);
				if (ms.getFuelLevel() == 0) {
					gameObjs.remove(i);
					i--; 
				}
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// Display Printer
	public void printDisplay() {
		PlayerShip ps = null;
		Boolean psBool = false;
		IIterator it = getIterator();

		for (int i = 0; i < it.size() && !psBool; i++) {
			if (it.elementAt(i) instanceof PlayerShip) {
				ps = (PlayerShip) it.elementAt(i);
				psBool = true;
			}
		}
		System.out.println("Current Score: " + this.getPlayScore() + " points");
		if (ps == null)
			this.PrintNoPS();
		else
			System.out.println("Missile count: " + ps.getMissileCount() + " missiles"); 
		System.out.println("Current elasped time: " + this.getGameTicks());
	}
	
	// Map Printer
	public void printMap() {
		IIterator it = getIterator();

		if (it.size() > 0)
			for (int i =0; i<it.size(); i++) {
				System.out.println((it.elementAt(i)));
			}
		else
			System.out.println("No GameObjects exist currently.");
	}
	
	public void setWidth(int width) {
		if(width > 0)
			this.w = width;
		else
			this.h = 500;
	}
	
	public void setHeight(int height) {
		if(height > 0) {
			this.h = height;
		}
		else
			this.h = 500;
	}
	
	
}