package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command{

	String diagTxt;
	public AboutCommand() {
		super("About");
		diagTxt = "";
		diagTxt += "David M. Williams\n";
		diagTxt += "CSC 133\n";
		diagTxt += "Doan Nguyen\n";
		diagTxt += "Asteroids v2 - A2\n";
		diagTxt += "Fall 2018\n";
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		Dialog.show("About", diagTxt, "Done", "Cancel");
	}
	
}
