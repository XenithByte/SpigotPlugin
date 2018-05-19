package de.xenithbyte.minigame.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;
    private static String prefix = "[MiniGame] ";

    public void onEnable() {
        plugin = this;

        Bukkit.getConsoleSender().sendMessage(prefix + "");
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static String getPrefix() {
        return prefix;
    }
}
