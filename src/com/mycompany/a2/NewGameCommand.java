package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NewGameCommand extends Command {
	public NewGameCommand() {
		super("New Game");
	}
	
	public void actionPerformed(ActionEvent evt) {
		System.out.println("New Game Has Been Attempted");
	}
}