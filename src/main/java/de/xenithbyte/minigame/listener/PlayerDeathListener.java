package de.xenithbyte.minigame.listener;

import de.xenithbyte.minigame.gamestates.GameState;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void handlePlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if(Main.getPlugin().getPlayers().contains(p)) {
            Main.getPlugin().getPlayers().remove(p);
            e.setDeathMessage(Main.getPrefix() + "Der Spieler §a" + p.getName() + " §7ist gestorben!");
            p.setGameMode(GameMode.SPECTATOR);
        }
        if(Main.getPlugin().getPlayers().size() == 1) {
            Bukkit.broadcastMessage(Main.getPrefix() + "Der Spieler §b" + Main.getPlugin().getPlayers().get(0).getName() + " §7hat gewonnen!");
            Main.getGameStateManager().setGameState(GameState.ENDING_STATE);
        }
    }

}
