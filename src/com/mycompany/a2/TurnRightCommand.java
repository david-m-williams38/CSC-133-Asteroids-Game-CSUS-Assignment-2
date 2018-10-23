package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TurnRightCommand extends Command {
	
	private GameWorld gw; 
	
	public TurnRightCommand(GameWorld gw) {
		super("Turn Player Ship Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.turnRight();
		 }
	}
}
