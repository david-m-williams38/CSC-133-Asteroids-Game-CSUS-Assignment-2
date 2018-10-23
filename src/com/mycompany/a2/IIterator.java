package com.mycompany.a2;

public interface IIterator {
	boolean hasNext();
	GameObject getNext();
	GameObject elementAt(int i);
	int size();
}