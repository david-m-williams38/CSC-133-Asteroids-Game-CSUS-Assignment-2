package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddAsteroidCommand extends Command {
    private GameWorld gw;

    public AddAsteroidCommand(GameWorld gw) {
        super("Add Asteroid");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getKeyEvent() != -1) {
            gw.addAsteroid();
        }
    }
}