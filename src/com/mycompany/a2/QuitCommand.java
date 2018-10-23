package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class QuitCommand extends Command {
	
	public QuitCommand() {
		super("Quit");
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getKeyEvent() != -1) {
			System.out.println("Attempting To Quit The Game...");
			if (Dialog.show("Confirm", "Do you really want to quit?", "Yes (Quit)", "No (Cancel)")) 
				System.exit(0);
		 }
	}
	
}
