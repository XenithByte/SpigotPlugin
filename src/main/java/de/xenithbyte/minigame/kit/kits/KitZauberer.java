package de.xenithbyte.minigame.kit.kits;

import de.xenithbyte.minigame.kit.Kit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitZauberer extends Kit {

    @Override
    public void addItems(Player p) {
        p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
        p.getInventory().addItem(new ItemStack(Material.ENCHANTMENT_TABLE));
        p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE, 14));
        p.getInventory().addItem(new ItemStack(Material.LAPIS_BLOCK,2));
    }

    @Override
    public void addEffects(Player p) {
        //none
    }
}
