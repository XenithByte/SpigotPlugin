package de.xenithbyte.minigame.kit.kits;

import de.xenithbyte.minigame.kit.Kit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitStarter extends Kit {

    @Override
    public void addItems(Player p) {
        p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
        p.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
        p.getInventory().addItem(new ItemStack(Material.IRON_AXE));
        p.getInventory().addItem(new ItemStack(Material.IRON_SPADE));
    }

    @Override
    public void addEffects(Player p) {
        //none
    }
}
