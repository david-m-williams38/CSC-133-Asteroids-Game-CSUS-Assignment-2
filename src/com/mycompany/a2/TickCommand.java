package com.mycompany.a2;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;

public class TickCommand extends Command {

	private GameWorld gw;
	
	public TickCommand(GameWorld gw) {
		super("Increase Game Ticks");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.tick();
		 }
	}
}
