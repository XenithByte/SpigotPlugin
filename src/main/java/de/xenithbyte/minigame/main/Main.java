package de.xenithbyte.minigame.main;

import de.xenithbyte.minigame.commands.SetLobbyCommand;
import de.xenithbyte.minigame.commands.SetSpawnCommand;
import de.xenithbyte.minigame.commands.StartCommand;
import de.xenithbyte.minigame.gamestates.GameState;
import de.xenithbyte.minigame.gamestates.GameStateManager;
import de.xenithbyte.minigame.kit.KitManager;
import de.xenithbyte.minigame.listener.*;
import de.xenithbyte.minigame.location.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    private static Main plugin;
    private static String prefix = "§8[§eSkyWars§8]§7 ",
                          no_permission = prefix + "Dazu hast du §ckeine Rechte§7!";
    private ArrayList<Player> players;

    private static GameStateManager gameStateManager;
    private static LocationManager locationManager;
    private static KitManager kitManager;

    @Override
    public void onEnable() {
        plugin = this;
        locationManager = new LocationManager();
        gameStateManager = new GameStateManager();
        kitManager = new KitManager();
        players = new ArrayList<>();
        gameStateManager.setGameState(GameState.LOBBY_STATE);

        init();
        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin ist gestartet.");
    }

    @Override
    public void onDisable() {
        MapResetListener.restore();
    }

    private void init() {
        this.getCommand("start").setExecutor(new StartCommand());
        this.getCommand("setlobby").setExecutor(new SetLobbyCommand());
        this.getCommand("setspawn").setExecutor(new SetSpawnCommand());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerConnectionListener(gameStateManager), this);
        pm.registerEvents(new KitSelectorListener(gameStateManager), this);
        pm.registerEvents(new ChestClickListener(gameStateManager), this);
        pm.registerEvents(new PlayerDeathListener(), this);
        pm.registerEvents(new AutoSmeltListener(), this);
        pm.registerEvents(new MapResetListener(), this);
    }

    public static ItemStack createItem(Material material, String displayName) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        item.setItemMeta(meta);
        return item;
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getNoPermission() {
        return no_permission;
    }

    public static GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public static LocationManager getLocationManager() {
        return locationManager;
    }

    public static KitManager getKitManager() {
        return kitManager;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
