package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection {
	
	private Vector<GameObject> gameObjects;
	
	// Constructor
	// This one sets up gameObjects as a new "list" (Vector-type list) of GameObjects
	public GameObjectCollection() {
		gameObjects = new Vector<GameObject>();
	}
	
	// Adds a new game object to the list
	public void add(GameObject newObject) {
		gameObjects.addElement(newObject);
	}

	// returns the data from the class below
	public IIterator getIterator() {
		return new GameObjectVectorIterator();
	}
	
	// Method to remove the specified element
	public void remove(GameObject object) {
		gameObjects.remove(object);	
	}
	
	// Method to remove the specified element
	public void remove(int indx) {
		gameObjects.remove(indx);
	}
	
	// Interior class for the IIterator interface
	// It is basically a pointer class for the GameObjects, Game... classes
	private class GameObjectVectorIterator implements IIterator {
		
		// Index number for the current pointer
		private int pointerIndex;
		
		// Start at -1, representing its emptiness
		public GameObjectVectorIterator() {
			pointerIndex = -1;
		}
		
		// Checks to see if there is another object in the next position of the list
		public boolean hasNext() {
			if (pointerIndex == (gameObjects.size() - 1) )
				return false;
			else if (gameObjects.size ( ) <= 0)
				return false;
			return true;
		}
		
		// Gets the next object positioned at the pointer, returning the next element
		public GameObject getNext() {
			pointerIndex++;
			return(gameObjects.elementAt(pointerIndex));
		}
		
		// Returns the element at the specified index
		public GameObject elementAt(int indx) {
			return gameObjects.elementAt(indx);
		}
		
		// Returns the size, for the Iterator pointer, and perhaps others
		public int size() {
			return gameObjects.size();
		}
		
	}

}