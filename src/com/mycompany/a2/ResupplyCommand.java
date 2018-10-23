package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ResupplyCommand extends Command {

	private GameWorld gw;
	
	public ResupplyCommand(GameWorld gw) {
		super("Resupply");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.newSupply();
		 }
	}

}
