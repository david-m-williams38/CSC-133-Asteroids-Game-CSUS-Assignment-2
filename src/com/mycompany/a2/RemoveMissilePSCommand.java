package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RemoveMissilePSCommand extends Command {

	private GameWorld gw;
	
	public RemoveMissilePSCommand(GameWorld gw) {
		super("Remove Missile & PS");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.removeMissilePS();
		 }
	}
	
}
