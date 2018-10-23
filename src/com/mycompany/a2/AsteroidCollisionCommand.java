package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AsteroidCollisionCommand extends Command {

	private GameWorld gw;
	
	public AsteroidCollisionCommand(GameWorld gw) {
		super("Remove Collided Asteroids");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.removeTwoAsteroids();
		 }
	}
	
}
