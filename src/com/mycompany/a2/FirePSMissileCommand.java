package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class FirePSMissileCommand extends Command {
	
	private GameWorld gw;
	
	public FirePSMissileCommand(GameWorld gw) {
		super("Fire Player Ship Missile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		 if (e.getKeyEvent() != -1) {
			 gw.firePSMissile();
		 }
	}
}