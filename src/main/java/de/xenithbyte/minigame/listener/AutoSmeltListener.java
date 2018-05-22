package de.xenithbyte.minigame.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class AutoSmeltListener implements Listener {

    Random random = new Random();

    @EventHandler
    public void handleBlockBreaking(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(e.getBlock().getType() == Material.DIAMOND_ORE) {
            e.getBlock().setType(Material.AIR);
            p.getInventory().addItem(new ItemStack(Material.DIAMOND, random.nextInt(3) + 1));
        }
        if(e.getBlock().getType() == Material.IRON_ORE) {
            e.getBlock().setType(Material.AIR);
            p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, random.nextInt(3) + 1));
        }
        if(e.getBlock().getType() == Material.GOLD_ORE) {
            e.getBlock().setType(Material.AIR);
            p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, random.nextInt(3) + 1));
        }
    }
}
