package de.xenithbyte.minigame.gamestates;

import de.xenithbyte.minigame.countdowns.EndingCountdown;

public class EndingState extends GameState {

    @Override
    public void start() {
        EndingCountdown endingCountdown = new EndingCountdown();
        endingCountdown.run();
    }

    @Override
    public void stop() {

    }

}
