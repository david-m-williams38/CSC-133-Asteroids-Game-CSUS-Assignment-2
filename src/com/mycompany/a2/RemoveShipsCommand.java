package com.mycompany.a2;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;

public class RemoveShipsCommand extends Command {

	private GameWorld gw;
	
	public RemoveShipsCommand(GameWorld gw) {
		super("Remove Non-Player Ship and Player Ship");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.removeNpsPs();
		 }
	}
	
}
