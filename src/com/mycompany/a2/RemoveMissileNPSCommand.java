package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RemoveMissileNPSCommand extends Command {

	private GameWorld gw;
	
	public RemoveMissileNPSCommand(GameWorld gw) {
		super("Remove Missile & NPS");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.removeMissileNPS();
		 }
	}
	
}
