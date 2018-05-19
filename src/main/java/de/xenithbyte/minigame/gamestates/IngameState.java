package de.xenithbyte.minigame.gamestates;

import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;

public class IngameState extends GameState {



    @Override
    public void start() {
        Bukkit.broadcastMessage(Main.getPrefix() + "Der Countdown ist beendet!");
        Bukkit.broadcastMessage(Main.getPrefix() + "Alle Spieler werden teleportiert!");
    }

    @Override
    public void stop() {

    }

}
