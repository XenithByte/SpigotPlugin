package de.xenithbyte.minigame.gamestates;

import de.xenithbyte.minigame.countdowns.IngameCountdown;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class IngameState extends GameState {

    IngameCountdown ingameCountdown;

    @Override
    public void start() {
        Bukkit.broadcastMessage(Main.getPrefix() + "Der Countdown ist beendet!");
        Bukkit.broadcastMessage(Main.getPrefix() + "Alle Spieler werden teleportiert!");
        int count = 1;
        for(Player p : Main.getPlugin().getPlayers()) {
            p.teleport(Main.getLocationManager().getSpawn(count));
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            p.setGameMode(GameMode.SURVIVAL);
            p.setExp(0);
            p.setLevel(0);
            p.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
            p.getInventory().addItem(new ItemStack(Material.IRON_AXE));
            p.getInventory().addItem(new ItemStack(Material.IRON_SPADE));
            count++;
        }
        ingameCountdown = new IngameCountdown();
        ingameCountdown.run();
    }

    @Override
    public void stop() {
        ingameCountdown.cancel();
    }

}
