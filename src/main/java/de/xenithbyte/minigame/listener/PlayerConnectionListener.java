package de.xenithbyte.minigame.listener;

import de.xenithbyte.minigame.gamestates.GameState;
import de.xenithbyte.minigame.gamestates.GameStateManager;
import de.xenithbyte.minigame.gamestates.LobbyState;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
            e.setJoinMessage(Main.getPrefix() + "§a" + p.getName() + "§7 hat das Spiel betreten. §8[§e" + Main.getPlugin().getPlayers().size() + "§7/§e" + LobbyState.MAX_PLAYERS +"§8]");
            if(Main.getLocationManager().getLobby() != null) {
                p.teleport(Main.getLocationManager().getLobby());
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.setGameMode(GameMode.SURVIVAL);
                p.setExp(0);
                p.setLevel(0);
            } else {
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.setGameMode(GameMode.SURVIVAL);
                p.setExp(0);
                p.setLevel(0);
                if(p.hasPermission("sw.admin")) {
                    p.sendMessage(Main.getPrefix() + "§cDie Lobby wurde noch nicht gesetzt!");
                }
            }
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
            e.setQuitMessage(Main.getPrefix() + "§a" +  p.getName() + "§7 hat das Spiel verlassen. §8[§e" + Main.getPlugin().getPlayers().size() + "§7/§e" + LobbyState.MAX_PLAYERS +"§8]");
            if(Main.getPlugin().getPlayers().size() == 1) {
                Bukkit.broadcastMessage(Main.getPrefix() + "Der Spieler §b" + Main.getPlugin().getPlayers().get(0).getName() + " §7hat gewonnen!");
                Main.getGameStateManager().setGameState(GameState.ENDING_STATE);
            }
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
