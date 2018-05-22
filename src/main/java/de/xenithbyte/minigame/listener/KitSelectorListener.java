package de.xenithbyte.minigame.listener;

import de.xenithbyte.minigame.gamestates.GameStateManager;
import de.xenithbyte.minigame.gamestates.LobbyState;
import de.xenithbyte.minigame.kit.kits.*;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelectorListener implements Listener {

    private GameStateManager gameStateManager;

    public KitSelectorListener(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(gameStateManager.getCurrentGameState() instanceof LobbyState) {
            ItemStack sword = new ItemStack(Material.IRON_SWORD);
            ItemMeta meta = sword.getItemMeta();
            meta.setDisplayName("§aKit Selector");
            sword.setItemMeta(meta);
            p.getInventory().setItem(4, sword);
        }
    }

    @EventHandler
    public void handleItemClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(gameStateManager.getCurrentGameState() instanceof LobbyState) {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK
                    || e.getAction() == Action.RIGHT_CLICK_AIR
                    || e.getAction() == Action.LEFT_CLICK_AIR
                    || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                if(p.getItemInHand().getType() == Material.IRON_SWORD) {
                    Inventory inv = Bukkit.createInventory(null, 9, "§aWähle ein Kit!");
                    inv.setItem(0, Main.createItem(Material.IRON_PICKAXE, "§6Starter"));
                    inv.setItem(1, Main.createItem(Material.ENDER_PEARL, "§6Enderman"));
                    inv.setItem(2, Main.createItem(Material.ENCHANTMENT_TABLE, "§6Zauberer"));
                    inv.setItem(3, Main.createItem(Material.WATER_BUCKET, "§6MLG"));
                    inv.setItem(4, Main.createItem(Material.DIAMOND_CHESTPLATE, "§6Tank"));
                    inv.setItem(5, Main.createItem(Material.GOLDEN_APPLE, "§6Heiler"));
                    p.openInventory(inv);
                }
            }
        }
    }

    @EventHandler
    public void handleItemDrop(PlayerDropItemEvent e) {
        if(gameStateManager.getCurrentGameState() instanceof LobbyState) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void handleInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if(gameStateManager.getCurrentGameState() instanceof LobbyState) {
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.IRON_PICKAXE) {
                Main.getKitManager().addPlayer(p, new KitStarter());
                p.sendMessage(Main.getPrefix() + "Du hast das Kit §5Starter §7gewählt!");
                p.getInventory().clear();
                p.getOpenInventory().close();
            }
            if(e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                Main.getKitManager().addPlayer(p, new KitEnderman());
                p.sendMessage(Main.getPrefix() + "Du hast das Kit §5Enderman §7gewählt!");
                p.getInventory().clear();
                p.getOpenInventory().close();
            }
            if(e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE) {
                Main.getKitManager().addPlayer(p, new KitZauberer());
                p.sendMessage(Main.getPrefix() + "Du hast das Kit §5Zauberer §7gewählt!");
                p.getInventory().clear();
                p.getOpenInventory().close();
            }
            if(e.getCurrentItem().getType() == Material.WATER_BUCKET) {
                Main.getKitManager().addPlayer(p, new KitMLG());
                p.sendMessage(Main.getPrefix() + "Du hast das Kit §5MLG §7gewählt!");
                p.getInventory().clear();
                p.getOpenInventory().close();
            }
            if(e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
                Main.getKitManager().addPlayer(p, new KitTank());
                p.sendMessage(Main.getPrefix() + "Du hast das Kit §5Tank §7gewählt!");
                p.getInventory().clear();
                p.getOpenInventory().close();
            }
            if(e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
                Main.getKitManager().addPlayer(p, new KitHeiler());
                p.sendMessage(Main.getPrefix() + "Du hast das Kit §5Heiler §7gewählt!");
                p.getInventory().clear();
                p.getOpenInventory().close();
            }
        }
    }

}
