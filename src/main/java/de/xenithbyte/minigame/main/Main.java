package de.xenithbyte.minigame.main;

import de.xenithbyte.minigame.gamestates.GameState;
import de.xenithbyte.minigame.gamestates.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;
    private static String prefix = "§8[§eMiniGame§8]§7 ";

    private static GameStateManager gameStateManager;

    public void onEnable() {
        plugin = this;
        gameStateManager = new GameStateManager();
        gameStateManager.setGameState(GameState.LOBBY_STATE);

        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin ist gestartet.");
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static GameStateManager getGameStateManager() {
        return gameStateManager;
    }
}
