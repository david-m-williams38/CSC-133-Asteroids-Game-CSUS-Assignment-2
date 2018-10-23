package com.mycompany.a2;

import com.codename1.ui.Form;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class Game extends Form {

	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	
	// Default constructor
	public Game() {
		/**
		 * gw = new GameWorld();
		 * gw.init();
		 * play();
		 */
		pv = new PointsView(gw);
		mv = new MapView();
		gw = new GameWorld();
		gw.addObserver(pv);
		gw.addObserver(mv);
		gw.init(mv.getWidth(), mv.getHeight());
		
		this.setLayout(new BorderLayout());
		
		Container xyCollection = new Container();
		xyCollection.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		Container yContainer = new Container();
		yContainer.setLayout(new FlowLayout(Component.CENTER));
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("CN1 Asteroids Game");

		NewGameCommand newGameCommand = new NewGameCommand();
		SaveCommand saveCommand = new SaveCommand();
		UndoCommand undoCommand = new UndoCommand();
		SoundCommand soundCommand = new SoundCommand(gw);
		AboutCommand aboutCommand = new AboutCommand();
		QuitCommand quitCommand = new QuitCommand();

		toolbar.addCommandToSideMenu(newGameCommand);
		toolbar.addCommandToSideMenu(saveCommand);
		toolbar.addCommandToSideMenu(undoCommand);
		//toolbar.addCommandToSideMenu(soundCommand);
		CheckBox soundBox = new CheckBox("Sound (On/Off): ");
		soundBox.setSelected(false);
		soundBox.setCommand(soundCommand);
		toolbar.addComponentToSideMenu(soundBox);
		toolbar.addCommandToSideMenu(aboutCommand);
		toolbar.addCommandToSideMenu(quitCommand);

		Container xContainer = new Container();
		xContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		xContainer.add(pv);
		
		xyCollection.add(yContainer);
		xyCollection.add(xContainer);
		this.add(BorderLayout.NORTH, xyCollection);
		
		Container westCollection = new Container();
		westCollection.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		westCollection.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
		
		AddNPSCommand addNPSCommand = new AddNPSCommand(gw);
		IncreaseSpeedCommand increaseSpeedCommand = new IncreaseSpeedCommand(gw);
		DecreaseSpeedCommand decreaseSpeedCommand = new DecreaseSpeedCommand(gw);
		TurnLeftCommand turnLeftCommand = new TurnLeftCommand(gw);
		TurnRightCommand turnRightCommand = new TurnRightCommand(gw);
		TurnLauncherCommand turnLauncherCommand = new TurnLauncherCommand(gw);
		FirePSMissileCommand fireMissileCommand = new FirePSMissileCommand(gw);
		JumpCommand jumpCommand = new JumpCommand(gw);
		RemoveMissileNPSCommand removeNPSCommand = new RemoveMissileNPSCommand(gw);
		RemoveMissilePSCommand removePSCommand = new RemoveMissilePSCommand(gw);
		RemoveShipsCommand removeDestroyedShips = new RemoveShipsCommand(gw);
		RemoveAsteroidNPSCommand removeAsteroidAndNPS = new RemoveAsteroidNPSCommand(gw);
		FireNPSMissileCommand fireNPSMissileCommand = new FireNPSMissileCommand(gw);
		
		AddAsteroidCommand addAsteroidCommand = new AddAsteroidCommand(gw);
		AddStationCommand addStationCommand = new AddStationCommand(gw);
		AddPSCommand addPSCommand = new AddPSCommand(gw);
		ResupplyCommand resupplyCommand = new ResupplyCommand(gw);
		RemoveMissileAsteroidCommand removeAsteroidCommand = new RemoveMissileAsteroidCommand(gw);
		RemovePSAsteroidCommand asteroidDestroyedCommand = new RemovePSAsteroidCommand(gw);
		AsteroidCollisionCommand AsteroidCollisionCommand = new AsteroidCollisionCommand(gw);
		TickCommand tickCommand = new TickCommand(gw);

		
		MyButton addAsteroidButton = new MyButton(addAsteroidCommand);
		MyButton addNPSButton = new MyButton(addNPSCommand);
		MyButton addStationButton = new MyButton(addStationCommand);
		MyButton addPSButton = new MyButton(addPSCommand);
		MyButton increaseSpeedAction = new MyButton(increaseSpeedCommand);
		MyButton decreaseSpeedAction = new MyButton(decreaseSpeedCommand);
		MyButton turnLeftAction = new MyButton(turnLeftCommand);
		MyButton turnRightAction = new MyButton(turnRightCommand);
		MyButton turnLauncherButton = new MyButton(turnLauncherCommand);
		MyButton fireMissileButton = new MyButton(fireMissileCommand);
		MyButton fireNPSMissileButton = new MyButton(fireNPSMissileCommand);
		MyButton jumpButton = new MyButton(jumpCommand);
		MyButton resupplyButton = new MyButton(resupplyCommand);
		MyButton asteroidDestroyedButton = new MyButton(removeAsteroidCommand);
		MyButton NPSDestroyedButton = new MyButton(removeNPSCommand);
		MyButton PSDestroyedButton = new MyButton(removePSCommand);
		MyButton asteroidsHitButton = new MyButton(asteroidDestroyedCommand);
		MyButton npsCollisionButton = new MyButton(removeDestroyedShips);
		MyButton asteroidsHitEachOtherButton = new MyButton(AsteroidCollisionCommand);
		MyButton asteroidNPSDestroyedButton = new MyButton(removeAsteroidAndNPS);
		MyButton gameUpdateButton = new MyButton(tickCommand);
		MyButton quitButton = new MyButton(quitCommand);


		
		westCollection.add(addAsteroidButton);
		westCollection.add(addPSButton);
		westCollection.add(addNPSButton);
		westCollection.add(addStationButton);
		westCollection.add(increaseSpeedAction);
		westCollection.add(decreaseSpeedAction);
		westCollection.add(turnLeftAction);
		westCollection.add(turnRightAction);
		westCollection.add(turnLauncherButton);
		westCollection.add(fireMissileButton);
		westCollection.add(jumpButton);
		westCollection.add(resupplyButton);
		westCollection.add(asteroidDestroyedButton);
		westCollection.add(NPSDestroyedButton);
		westCollection.add(PSDestroyedButton);
		westCollection.add(asteroidsHitButton);
		westCollection.add(npsCollisionButton);
		westCollection.add(fireNPSMissileButton);
		westCollection.add(asteroidsHitEachOtherButton);
		westCollection.add(asteroidNPSDestroyedButton);
		westCollection.add(gameUpdateButton);
		westCollection.add(quitButton);
		
		this.add(BorderLayout.WEST, westCollection);
		
		this.addKeyListener(-91, increaseSpeedCommand);
		this.addKeyListener(-92, decreaseSpeedCommand);
		this.addKeyListener(-93, turnLeftCommand);
		this.addKeyListener(-94, turnRightCommand);
		this.addKeyListener(-90, fireMissileCommand);
		this.addKeyListener('j', jumpCommand);
		
		this.add(BorderLayout.CENTER, mv);
		
		this.show(); // BECAUSE YOU GOTTA SHOW IT OFF IF YOU HAVE IT
		}
	
	
	/**
	// This method handles all the commands that will be executed
	// These commands will later be mapped to buttons and other such items
	// 		that will be implemented later, allowing for user control (Later)
	@SuppressWarnings("rawtypes")
	private void play() {
		// Given Code
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				if(didQuit) {
					switch(sCommand.charAt(0)) {
					case 'Y':
					case 'y':
						Display.getInstance().exitApplication();;
						break;
					case 'N':
					case 'n':
						System.out.println("You have selected to not quit, let's keep playing!");
						didQuit = false;
						break;
					default:
						System.out.println("Invalid Input Given! Resuming Game...");
						didQuit = false;
					}
				}
				// This try/catch block exists if the user finds a bug that could occur
				// The main bug involves the interface crashing when the user clicks 
				//			outside of the window after clicking the text box input
				try {
					switch (sCommand.charAt(0)) {
					case 'q':
						didQuit = true;
						System.out.println("Want to quit game? 'Y' or 'N'");
						break;
					case 'a':
						gw.addAsteroid();
						break;
					case 'm':
						gw.printMap();
						break;
					case 'y':
						gw.addNPS();
						break;
					case 'b':
						gw.addStation();
						break;
					case 's':
						gw.addPS();
						break;
					case 'i':
						gw.increasePSS();
						break;
					case 'd':
						gw.decreasePSS();
						break;
					case 'l':
						gw.turnLeft();
						break;
					case 'r':
						gw.turnRight();
						break;
					case '<':
						gw.turnPSML();
						break;
					case 'f':
						gw.firePSMissile();
						break;
					case 'L':
						gw.fireNPSMissile();
						break;
					case 'j':
						gw.jump();
						break;
					case 'n':
						gw.newSupply();
						break;
					case 'k':
						gw.removeMissileAsteroid();
						break;
					case 'e':
						gw.removeMissileNPS();
						break;
					case 'E':
						gw.removeMissilePS();
						break;
					case 'c':
						gw.removePSAsteroid();
						break;
					case 'h':
						gw.removeNpsPs();
						break;
					case 'x':
						gw.removeTwoAsteroids();
						break;
					case 'I':
						gw.removeAsteroidNPS();
						break;
					case 't':
						gw.tick();
						break;
					case 'p':
						gw.printDisplay();
						break;
					default:
						System.out.println("Invalid Input Given!");
					}
				}
				// This catch block will catch ALL errors, preventing the interface from crashing,
				//		Such as a NullPointerException and so on....
				catch(Exception E) {
					System.out.println("The interface has crashed! But don't worry!");
				}
			}
		});
	}**/
	
}
