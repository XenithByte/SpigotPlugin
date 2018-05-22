package de.xenithbyte.minigame.commands;

import de.xenithbyte.minigame.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLobbyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("sw.admin")) {
                if(args.length == 0) {
                    Main.getLocationManager().setLobby(p.getLocation());
                    p.sendMessage(Main.getPrefix() + "Die Lobby wurde erfolgreich gesetzt!");
                } else
                    p.sendMessage(Main.getPrefix() + "Bitte benutze §8/§asetlobby§7!");
            } else
                p.sendMessage(Main.getNoPermission());
        }
        return false;
    }
}
