package de.xenithbyte.minigame.commands;

import de.xenithbyte.minigame.gamestates.LobbyState;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    /*
        Permissions
        - sw.start
        - sw.admin
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("sw.start")) {
                if(args.length == 0) {

                    if(Main.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
                        LobbyState lobbyState = (LobbyState) Main.getGameStateManager().getCurrentGameState();
                        if(lobbyState.getLobbyCountdown().isRunning()) {
                            if(!lobbyState.getLobbyCountdown().isStarting()) {
                                lobbyState.getLobbyCountdown().setSeconds(3);
                                lobbyState.getLobbyCountdown().setStarting(true);
                            } else
                                p.sendMessage(Main.getPrefix() + "Das Spiel startet bereits!");
                        } else
                            p.sendMessage(Main.getPrefix() + "Es fehlen noch Spieler bis zum Countdown!");
                    } else
                        p.sendMessage(Main.getPrefix() + "Die Lobby-Phase ist bereits beendet!");
                } else
                    p.sendMessage(Main.getPrefix() + "Bitte benutze §8/§astart§7!");
            } else
                p.sendMessage(Main.getNoPermission());
        }
        return false;
    }
}
