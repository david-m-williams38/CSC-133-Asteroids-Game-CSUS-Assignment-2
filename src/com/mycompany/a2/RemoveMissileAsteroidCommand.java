package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RemoveMissileAsteroidCommand extends Command{
	
	private GameWorld gw;
	
	public RemoveMissileAsteroidCommand(GameWorld gw) {
		super("Remove Missile & Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.removeMissileAsteroid();
		 }
	}

}
