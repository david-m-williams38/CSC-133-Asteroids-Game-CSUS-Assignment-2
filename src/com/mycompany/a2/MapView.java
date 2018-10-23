package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import java.util.Observable;
import java.util.Observer;

public class MapView extends Container implements Observer  {
	
	public MapView() {
		Container mapCollection = new Container();
		mapCollection.setLayout( new FlowLayout() );
		mapCollection.getAllStyles().setBgTransparency(255);
		mapCollection.getAllStyles().setBgColor(ColorUtil.GRAY);
		this.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		this.add(mapCollection);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		IGameWorld gw = (IGameWorld) arg;
		System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~MAP~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n"
				+ "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
		gw.printMap();
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n"
				+ "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
		System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
		this.repaint();
	}
}