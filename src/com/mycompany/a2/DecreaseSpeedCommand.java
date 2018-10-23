package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class DecreaseSpeedCommand extends Command{

	private GameWorld gw;
	
	public DecreaseSpeedCommand(GameWorld gw) {
		super("Decrease Player Speed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getKeyEvent() != -1) {
			 gw.decreasePSS();
		 }
	}
	
}
