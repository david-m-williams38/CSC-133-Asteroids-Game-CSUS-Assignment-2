package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TurnLauncherCommand extends Command{

	private GameWorld gw;
	
	public TurnLauncherCommand(GameWorld gw) {
		super("Turn Player Ship ML Left");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.turnPSML();
		 }
	}
	
}
