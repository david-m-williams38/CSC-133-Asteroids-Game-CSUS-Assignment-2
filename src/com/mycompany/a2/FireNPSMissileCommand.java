package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FireNPSMissileCommand extends Command {

	private GameWorld gw;
	
	public FireNPSMissileCommand(GameWorld gw) {
		super("Launch Non-Player Ship Missile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.fireNPSMissile();
		 }
	}

}
