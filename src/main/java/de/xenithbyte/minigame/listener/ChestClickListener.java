package de.xenithbyte.minigame.listener;

import de.xenithbyte.minigame.gamestates.GameStateManager;
import de.xenithbyte.minigame.gamestates.IngameState;
import de.xenithbyte.minigame.gamestates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ChestClickListener implements Listener {

    private HashMap<Location, Inventory> chests = new HashMap<>();

    private List<ItemStack> items = new ArrayList<>();

    private GameStateManager gameStateManager;

    public ChestClickListener(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        initItems();
    }

    public void handleChestClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(gameStateManager.getCurrentGameState() instanceof IngameState) {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CHEST) {
                if(chests.containsKey(e.getClickedBlock().getLocation())) {
                    p.openInventory(chests.get(e.getClickedBlock().getLocation()));
                } else {
                    Random random = new Random();
                    int maxItems = random.nextInt(6) + 1;
                    Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST);
                    while (maxItems != 0) {
                        maxItems--;
                        int slot = random.nextInt(27);
                        int item = random.nextInt(items.size());

                        inventory.setItem(slot, items.get(item));
                    }
                    chests.put(e.getClickedBlock().getLocation(), inventory);
                }
            }
        }

    }

    private void initItems() {
        //swords
        items.add(new ItemStack(Material.WOOD_SWORD));
        items.add(new ItemStack(Material.WOOD_SWORD));
        items.add(new ItemStack(Material.WOOD_SWORD));
        items.add(new ItemStack(Material.WOOD_SWORD));

        items.add(new ItemStack(Material.STONE_SWORD));
        items.add(new ItemStack(Material.STONE_SWORD));
        items.add(new ItemStack(Material.STONE_SWORD));

        items.add(new ItemStack(Material.IRON_SWORD));
        items.add(new ItemStack(Material.IRON_SWORD));

        items.add(new ItemStack(Material.DIAMOND_SWORD));

        //armor
        items.add(new ItemStack(Material.IRON_BOOTS));
        items.add(new ItemStack(Material.IRON_BOOTS));
        items.add(new ItemStack(Material.IRON_BOOTS));

        items.add(new ItemStack(Material.IRON_LEGGINGS));
        items.add(new ItemStack(Material.IRON_LEGGINGS));
        items.add(new ItemStack(Material.IRON_LEGGINGS));

        items.add(new ItemStack(Material.IRON_CHESTPLATE));
        items.add(new ItemStack(Material.IRON_CHESTPLATE));
        items.add(new ItemStack(Material.IRON_CHESTPLATE));

        items.add(new ItemStack(Material.IRON_HELMET));
        items.add(new ItemStack(Material.IRON_HELMET));
        items.add(new ItemStack(Material.IRON_HELMET));

        items.add(new ItemStack(Material.DIAMOND_BOOTS));

        items.add(new ItemStack(Material.DIAMOND_LEGGINGS));

        items.add(new ItemStack(Material.DIAMOND_CHESTPLATE));

        items.add(new ItemStack(Material.DIAMOND_HELMET));

        //blocks
        items.add(new ItemStack(Material.BRICK, 64));
        items.add(new ItemStack(Material.BRICK, 32));
        items.add(new ItemStack(Material.BRICK, 16));
        items.add(new ItemStack(Material.BRICK, 35));
        items.add(new ItemStack(Material.BRICK, 41));

        items.add(new ItemStack(Material.STONE, 8));
        items.add(new ItemStack(Material.STONE, 16));
        items.add(new ItemStack(Material.STONE, 50));
        items.add(new ItemStack(Material.STONE, 33));

        items.add(new ItemStack(Material.WOOD_PLATE, 63));
        items.add(new ItemStack(Material.WOOD_PLATE, 64));
        items.add(new ItemStack(Material.WOOD_PLATE, 21));
        items.add(new ItemStack(Material.WOOD_PLATE, 12));
        items.add(new ItemStack(Material.WOOD_PLATE, 33));
        items.add(new ItemStack(Material.WOOD_PLATE, 50));

        //other
        items.add(new ItemStack(Material.EXP_BOTTLE, 16));
        items.add(new ItemStack(Material.EXP_BOTTLE, 12));
        items.add(new ItemStack(Material.EXP_BOTTLE, 8));
        items.add(new ItemStack(Material.EXP_BOTTLE, 4));

        items.add(new ItemStack(Material.LAPIS_BLOCK, 4));
        items.add(new ItemStack(Material.LAPIS_BLOCK, 2));
        items.add(new ItemStack(Material.LAPIS_BLOCK, 1));
        items.add(new ItemStack(Material.LAPIS_BLOCK, 3));

        //food
        items.add(new ItemStack(Material.APPLE, new Random().nextInt(9) + 1));
        items.add(new ItemStack(Material.COOKED_BEEF, new Random().nextInt(15) + 1));
        items.add(new ItemStack(Material.COOKED_CHICKEN, new Random().nextInt(15) + 1));
        items.add(new ItemStack(Material.COOKED_FISH, new Random().nextInt(15) + 1));
        items.add(new ItemStack(Material.COOKED_MUTTON, new Random().nextInt(15) + 1));
        items.add(new ItemStack(Material.COOKED_RABBIT, new Random().nextInt(15) + 1));
        items.add(new ItemStack(Material.CARROT_ITEM, new Random().nextInt(15) + 1));
        items.add(new ItemStack(Material.COOKIE, new Random().nextInt(15) + 1));
    }
}
