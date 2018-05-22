package de.xenithbyte.minigame.countdowns;

import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class EndingCountdown extends Countdown {

    private int seconds = 10;

    @Override
    public void run() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(Main.getLocationManager().getLobby());
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            p.setGameMode(GameMode.SURVIVAL);
            p.setExp(0);
            p.setLevel(0);
            p.setHealth(20);
            p.setFoodLevel(20);
        }
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), () -> {
            switch (seconds) {
                case 10: case 5: case 4: case 3: case 2:
                    Bukkit.broadcastMessage(Main.getPrefix() + "Der Server schließt in §c" + seconds + " §7Sekunden.");
                    break;
                case 1:
                    Bukkit.broadcastMessage(Main.getPrefix() + "Der Server schließt in §ceiner §7Sekunde.");
                    break;
                case 0:
                    Bukkit.getServer().shutdown();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
                    break;
                default:
                    break;
            }

            seconds--;
        },0, 20);
    }

    @Override
    public void cancel() {
        Bukkit.getScheduler().cancelTask(taskID);
    }

}
