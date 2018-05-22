package de.xenithbyte.minigame.kit.kits;

import de.xenithbyte.minigame.kit.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class KitHeiler extends Kit {

    @Override
    public void addItems(Player p) {
        p.getInventory().addItem(new ItemStack(Material.GOLD_SWORD));
        p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
        p.getInventory().addItem(new ItemStack(Material.POTION, 1, (short)8197));
        p.getInventory().addItem(new ItemStack(Material.POTION, 1, (short)8197));

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta)chestplate.getItemMeta();
        chestplate.setItemMeta(meta);
        meta.setColor(Color.RED);

        p.getInventory().setChestplate(chestplate);
    }

    @Override
    public void addEffects(Player p) {

    }
}
