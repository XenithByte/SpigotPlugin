package de.xenithbyte.minigame.kit.kits;

import de.xenithbyte.minigame.kit.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitTank extends Kit {

    @Override
    public void addItems(Player p) {
        p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));

        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        p.getInventory().setHelmet(helmet);

        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        p.getInventory().setChestplate(chestplate);

        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        p.getInventory().setLeggings(leggings);

        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        p.getInventory().setBoots(boots);

    }

    @Override
    public void addEffects(Player p) {

    }
}
