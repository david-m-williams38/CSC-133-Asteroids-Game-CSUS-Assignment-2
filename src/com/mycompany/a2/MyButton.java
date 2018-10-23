package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.Border;

public class MyButton extends Button {

	public MyButton(Command com) {
		super(com);
		this.getAllStyles().setBgTransparency(225);
		this.getAllStyles().setBgColor(ColorUtil.BLACK);
		this.getAllStyles().setFgColor(ColorUtil.WHITE);
		this.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.CYAN));
		this.getPressedStyle().setFgColor(ColorUtil.rgb(100, 20, 100), true);
		this.getPressedStyle().setBgColor(ColorUtil.rgb(255, 150, 150), true);
	}
	
}
