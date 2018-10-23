package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddStationCommand extends Command{

	private GameWorld gw;
	
	public AddStationCommand(GameWorld gw) {
		super("Add Station");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getKeyEvent() != -1) {
			 gw.addStation();
		 }
	}
	
}
