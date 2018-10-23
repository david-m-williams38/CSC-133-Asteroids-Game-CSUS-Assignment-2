package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RemoveAsteroidNPSCommand extends Command {

	private GameWorld gw;
	
	public RemoveAsteroidNPSCommand(GameWorld gw) {
		super("Remove Non-Player Ship & Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.removeAsteroidNPS();
		 }
	}
	
}
