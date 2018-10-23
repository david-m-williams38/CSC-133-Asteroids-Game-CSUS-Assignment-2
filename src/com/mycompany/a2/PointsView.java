package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointsView extends Container implements Observer 
{
	private Label numberOfPointsLabel;
	private Label numberOfMissilesLabel;
	private Label totalTimeLabel;
	private Label soundBoolLabel;
	private Label numberOfLivesLabel;
	
	public PointsView(GameWorld gw) 
	{
		// Instantiate text labels
		Label pointsNumLabel = new Label ("Points: ");
		Label missileNumLabel = new Label ("Missile Count: ");
		Label timeTotalLabel = new Label("Elapsed Time: ");
		Label soundOnOffLabel = new Label("Sound (On/Off): ");
		Label totalLivesLabel = new Label("Lives: ");
		
		pointsNumLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		pointsNumLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		pointsNumLabel.getAllStyles().setBgTransparency(255);
		 
		missileNumLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		missileNumLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		missileNumLabel.getAllStyles().setBgTransparency(255);
		 
		timeTotalLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		timeTotalLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		timeTotalLabel.getAllStyles().setBgTransparency(255);
		 
		soundOnOffLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		soundOnOffLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		soundOnOffLabel.getAllStyles().setBgTransparency(255);
		
		totalLivesLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		totalLivesLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		totalLivesLabel.getAllStyles().setBgTransparency(255);
		
		numberOfPointsLabel = new Label ("XXXXX");
		numberOfMissilesLabel = new Label ("XXXXX");
		totalTimeLabel= new Label ("XXXXX");
		soundBoolLabel= new Label ("XXXXX");
		numberOfLivesLabel= new Label ("XXXXX");
		
		numberOfPointsLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		numberOfPointsLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		numberOfPointsLabel.getAllStyles().setBgTransparency(255);

		numberOfMissilesLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		numberOfMissilesLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		numberOfMissilesLabel.getAllStyles().setBgTransparency(255);
		
		totalTimeLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		totalTimeLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		totalTimeLabel.getAllStyles().setBgTransparency(255);
		
		soundBoolLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		soundBoolLabel.getAllStyles().setBgColor(ColorUtil.WHITE);
		soundBoolLabel.getAllStyles().setBgTransparency(255);

		numberOfLivesLabel.getAllStyles().setBgColor(ColorUtil.WHITE);		
		numberOfLivesLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		numberOfLivesLabel.getAllStyles().setBgTransparency(255);

		Container myCollection = new Container();
		myCollection.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		myCollection.add(pointsNumLabel);
		myCollection.add(numberOfPointsLabel);
		
		myCollection.add(missileNumLabel);
		myCollection.add(numberOfMissilesLabel);
		
		myCollection.add(timeTotalLabel);
		myCollection.add(totalTimeLabel);
		
		myCollection.add(soundOnOffLabel);
		myCollection.add(soundBoolLabel);
		
		myCollection.add(totalLivesLabel);
		myCollection.add(numberOfLivesLabel);
		
		this.add(myCollection);
	}

	@Override
	public void update(Observable observable, Object arg) {
		IGameWorld gw = (IGameWorld) arg;
		
		numberOfPointsLabel.setText("" + gw.getPlayScore());
		
		numberOfMissilesLabel.setText("" + gw.getMissileCount());

		totalTimeLabel.setText("" + gw.getGameTicks());
		
		boolean sound = gw.getSound();
		
		if(sound == false)
			soundBoolLabel.setText("OFF");
		else
			soundBoolLabel.setText("ON");
		
		numberOfLivesLabel.setText("" + gw.getPlayLives() + "        ");
		
		
		
		this.repaint();
	}

}