package de.xenithbyte.minigame.countdowns;

import de.xenithbyte.minigame.gamestates.GameState;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;

public class IngameCountdown extends Countdown {

    private int seconds = 60 * 15;

    @Override
    public void run() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                switch (seconds) {
                    case 60 * 15:
                        Bukkit.broadcastMessage(Main.getPrefix() + "Das Spiel endet in §c15 §7Minuten!");
                        break;
                    case 60 * 10:
                        Bukkit.broadcastMessage(Main.getPrefix() + "Das Spiel endet in §c10 §7Minuten!");
                        break;
                    case 60 * 5:
                        Bukkit.broadcastMessage(Main.getPrefix() + "Das Spiel endet in §c5 §7Minuten!");
                        break;
                    case 60 * 1:
                        Bukkit.broadcastMessage(Main.getPrefix() + "Das Spiel endet in §ceiner §7Minute!");
                        break;
                    case 45: case 30: case 15: case 10: case 5: case 4: case 3: case 2:
                        Bukkit.broadcastMessage(Main.getPrefix() + "Das Spiel endet in §c" + seconds + "");
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Main.getPrefix() + "Das Spiel beginnt in §ceiner §7Sekunde!");
                        break;
                    case 0:
                        Bukkit.broadcastMessage(Main.getPrefix() + "Leider hat §bniemand §7hat gewonnen!");
                        Main.getGameStateManager().setGameState(GameState.ENDING_STATE);
                        break;
                    default:
                        break;
                }
                seconds--;
            }
        }, 0, 20 * 1);
    }

    @Override
    public void cancel() {
        Bukkit.getScheduler().cancelTask(taskID);
    }
}
