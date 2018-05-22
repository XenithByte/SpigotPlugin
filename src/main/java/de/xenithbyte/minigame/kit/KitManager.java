package de.xenithbyte.minigame.kit;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class KitManager {

    private HashMap<Player, Kit> kitHashMap = new HashMap<>();

    public void addPlayer(Player p, Kit kit) {
        kitHashMap.put(p, kit);
    }

    public HashMap<Player, Kit> getKitHashMap() {
        return kitHashMap;
    }
}
