package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddPSCommand extends Command{

	private GameWorld gw;
	
	public AddPSCommand(GameWorld gw) {
		super("Add Player Ship");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getKeyEvent() != -1) {
			 gw.addPS();
		 }
	}
	
}
