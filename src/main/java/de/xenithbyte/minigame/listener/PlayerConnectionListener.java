package de.xenithbyte.minigame.listener;

import de.xenithbyte.minigame.gamestates.GameStateManager;
import de.xenithbyte.minigame.gamestates.LobbyState;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    private GameStateManager gameStateManager;

    public PlayerConnectionListener(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(gameStateManager.getCurrentGameState() instanceof LobbyState) {
            LobbyState lobbyState = (LobbyState) gameStateManager.getCurrentGameState();
            Main.getPlugin().getPlayers().add(p);
            e.setJoinMessage(Main.getPrefix() + "§a" + p.getName() + "§7 hat das Spiel betreten. §8[§e" + Main.getPlugin().getPlayers().size() + "§7/§e " + LobbyState.MAX_PLAYERS +"§8]");
            if(Main.getPlugin().getPlayers().size() >= LobbyState.MIN_PLAYERS) {
                if(!lobbyState.getLobbyCountdown().isRunning()) {
                    if(lobbyState.getLobbyCountdown().isIdling())
                        lobbyState.getLobbyCountdown().cancelIdle();
                    lobbyState.getLobbyCountdown().run();
                }
            }
        }
    }

    @EventHandler
    public void handlePlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(gameStateManager.getCurrentGameState() instanceof LobbyState) {
            LobbyState lobbyState = (LobbyState) gameStateManager.getCurrentGameState();
            Main.getPlugin().getPlayers().remove(p);
            e.setQuitMessage(Main.getPrefix() + "§a" +  p.getName() + "§7 hat das Spiel verlassen. §8[§e" + Main.getPlugin().getPlayers().size() + "§7/§e " + LobbyState.MAX_PLAYERS +"§8]");
            if(Main.getPlugin().getPlayers().size() < LobbyState.MIN_PLAYERS) {
                if(lobbyState.getLobbyCountdown().isRunning()) {
                    lobbyState.getLobbyCountdown().cancel();
                    if(!lobbyState.getLobbyCountdown().isIdling())
                        lobbyState.getLobbyCountdown().idle();
                }
            }
        }

    }

}
