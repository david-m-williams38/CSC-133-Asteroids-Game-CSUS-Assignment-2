package com.mycompany.a2;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;

public class RemovePSAsteroidCommand extends Command {

	private GameWorld gw;
	
	public RemovePSAsteroidCommand(GameWorld gw) {
		super("Remove Player Ship and Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.removePSAsteroid();
		 }
	}
	
}
