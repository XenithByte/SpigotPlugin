package de.xenithbyte.minigame.kit.kits;

import de.xenithbyte.minigame.kit.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitMLG extends Kit {

    @Override
    public void addItems(Player p) {
        p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
        p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
        p.getInventory().addItem(new ItemStack(Material.TNT, 12));
        p.getInventory().addItem(new ItemStack(Material.WEB, 8));
        p.getInventory().addItem(new ItemStack(Material.WOOD_PLATE, 8));
        p.getInventory().addItem(new ItemStack(Material.WOOD, 64));
        p.getInventory().addItem(new ItemStack(Material.BOAT));

        ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
        helmet.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().setHelmet(helmet);

        ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE);
        chestplate.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().setChestplate(chestplate);

        ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS);
        leggings.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().setLeggings(leggings);

        ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
        boots.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().setBoots(boots);
    }

    @Override
    public void addEffects(Player p) {
        //none
    }
}
