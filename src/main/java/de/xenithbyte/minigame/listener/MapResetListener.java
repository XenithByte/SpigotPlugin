package de.xenithbyte.minigame.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.LinkedList;
import java.util.List;

public class MapResetListener implements Listener {

    private static List<String> broken = new LinkedList<>();
    private static List<Block> placed = new LinkedList<>();

    public static void restore() {
        for(String s : broken) {
            String[] array = s.split(";");
            int x = Integer.valueOf(array[0]);
            int y = Integer.valueOf(array[1]);
            int z = Integer.valueOf(array[2]);
            int id = Integer.valueOf(array[3]);
            byte data = Byte.valueOf(array[4]);
            String world = array[5];

            Location loc = new Location(Bukkit.getWorld(world), x, y, z);
            loc.getBlock().setTypeId(id);
            loc.getBlock().setData(data);
        }

        for(Block b : placed) {
            b.getWorld().getBlockAt(b.getLocation()).setType(Material.AIR);
        }
    }

    @EventHandler
    public void handleBreakBlock(BlockBreakEvent e) {
        Block b = e.getBlock();
        broken.add(b.getLocation().getBlockX() + ";"
                 + b.getLocation().getBlockY() + ";"
                 + b.getLocation().getBlockZ() + ";"
                 + b.getTypeId()               + ";"
                 + b.getData()                 + ";"
                 + b.getWorld().getName()
        );
    }

    @EventHandler
    public void handlePlaceBlock(BlockPlaceEvent e) {
        Block b = e.getBlock();
        placed.add(b);
    }

}
