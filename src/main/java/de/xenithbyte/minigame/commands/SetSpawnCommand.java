package de.xenithbyte.minigame.commands;

import de.xenithbyte.minigame.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("sw.admin")) {
                if(args.length == 1) {
                    Main.getLocationManager().setSpawn(p.getLocation(), Integer.parseInt(args[0]));
                    p.sendMessage(Main.getPrefix() + "Der Spawn §a" + args[0] + " §7wurde erfolgreich gesetzt!");
                } else
                    p.sendMessage(Main.getPrefix() + "Bitte benutze §8/§asetspawn <1-16>§7!");
            } else
                p.sendMessage(Main.getNoPermission());
        }
        return false;
    }

}
