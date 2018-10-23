package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class JumpCommand extends Command {
	
	private GameWorld gw;
	
	public JumpCommand(GameWorld gw) {
		super("Jump through Hypospace");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getKeyEvent() != -1) {
			 gw.jump();
		 }
	}
}
