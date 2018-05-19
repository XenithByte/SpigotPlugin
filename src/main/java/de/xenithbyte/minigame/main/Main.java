package de.xenithbyte.minigame.main;

import de.xenithbyte.minigame.gamestates.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;
    private static String prefix = "[MiniGame] ";

    private static GameStateManager gameStateManager;

    public void onEnable() {
        plugin = this;
        gameStateManager = new GameStateManager();

        Bukkit.getConsoleSender().sendMessage(prefix + "");
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
