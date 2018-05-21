package de.xenithbyte.minigame.location;

import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LocationManager {

    public File file = new File("plugins/" + Main.getPlugin().getName(), "locations.yml");
    public FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void setLobby(Location loc) {
        cfg.set("Lobby.World", loc.getWorld().getName());
        cfg.set("Lobby.X", loc.getX());
        cfg.set("Lobby.Y", loc.getY());
        cfg.set("Lobby.Z", loc.getZ());
        save();
    }

    public Location getLobby() {
        World world = Bukkit.getWorld(cfg.getString("Lobby.World"));
        double x = cfg.getDouble("Lobby.X");
        double y = cfg.getDouble("Lobby.Y");
        double z = cfg.getDouble("Lobby.Z");
        return new Location(world, x, y, z);
    }

    public void setSpawn(Location loc, int num) {
        cfg.set("Spawn." + num + ".World", loc.getWorld().getName());
        cfg.set("Spawn." + num + ".X", loc.getX());
        cfg.set("Spawn." + num + ".Y", loc.getY());
        cfg.set("Spawn." + num + ".Z", loc.getZ());
        save();
    }

    public Location getSpawn(int num) {
        World world = Bukkit.getWorld(cfg.getString("Spawn." + num + ".World"));
        double x = cfg.getDouble("Spawn." + num + ".X");
        double y = cfg.getDouble("Spawn." + num + ".Y");
        double z = cfg.getDouble("Spawn." + num + ".Z");
        return new Location(world, x, y, z);
    }

    public void save() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(Main.getPrefix() + "§4Config konnte nicht gespeichert werden.");
        }
    }

}
