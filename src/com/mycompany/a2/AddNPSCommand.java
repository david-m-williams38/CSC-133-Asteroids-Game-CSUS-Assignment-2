package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddNPSCommand extends Command{

	private GameWorld gw;
	
	public AddNPSCommand(GameWorld gw) {
		super("Add Non-Player Ship");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getKeyEvent() != -1) {
			 gw.addNPS();
		 }
	}
	
}
