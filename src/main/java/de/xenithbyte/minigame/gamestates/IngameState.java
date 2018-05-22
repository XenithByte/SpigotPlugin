package de.xenithbyte.minigame.gamestates;

import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class IngameState extends GameState {



    @Override
    public void start() {
        Bukkit.broadcastMessage(Main.getPrefix() + "Der Countdown ist beendet!");
        Bukkit.broadcastMessage(Main.getPrefix() + "Alle Spieler werden teleportiert!");
        int count = 1;
        for(Player p : Main.getPlugin().getPlayers()) {
            p.teleport(Main.getLocationManager().getSpawn(count));
            count++;
        }
    }

    @Override
    public void stop() {

    }

}
