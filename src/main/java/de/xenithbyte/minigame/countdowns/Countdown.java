package de.xenithbyte.minigame.countdowns;

public abstract class Countdown {

    protected int taskID;

    public abstract void run();
    public abstract void cancel();

}
