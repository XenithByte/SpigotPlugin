package de.xenithbyte.minigame.gamestates;

import de.xenithbyte.minigame.countdowns.IngameCountdown;
import de.xenithbyte.minigame.kit.Kit;
import de.xenithbyte.minigame.kit.kits.KitStarter;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class IngameState extends GameState {

    private IngameCountdown ingameCountdown;

    @Override
    public void start() {
        Bukkit.broadcastMessage(Main.getPrefix() + "Der Countdown ist beendet!");
        Bukkit.broadcastMessage(Main.getPrefix() + "Alle Spieler werden teleportiert!");
        int count = 1;
        for(Player p : Main.getPlugin().getPlayers()) {
            p.teleport(Main.getLocationManager().getSpawn(count));
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            p.setGameMode(GameMode.SURVIVAL);
            p.setExp(0);
            p.setLevel(0);
            if(!Main.getKitManager().getKitHashMap().containsKey(p)) {
                Main.getKitManager().getKitHashMap().put(p, new KitStarter());
            }
            count++;
        }
        for(Player p : Main.getKitManager().getKitHashMap().keySet()) {
            Kit kit = Main.getKitManager().getKitHashMap().get(p);
            kit.addItems(p);
            kit.addEffects(p);
        }



        ingameCountdown = new IngameCountdown();
        ingameCountdown.run();
    }

    @Override
    public void stop() {
        ingameCountdown.cancel();
    }

}
