package de.xenithbyte.minigame.countdowns;

import de.xenithbyte.minigame.gamestates.GameState;
import de.xenithbyte.minigame.gamestates.LobbyState;
import de.xenithbyte.minigame.main.Main;
import org.bukkit.Bukkit;

public class LobbyCountdown extends Countdown {

    private final int RESET_SECONDS = 10;
    private final int IDLE_SECONDS = 20;

    private int idleID;
    private boolean isRunning = false, isIdling = false, isStarting = false;
    private int seconds = 15;

    @Override
    public void run() {
        isRunning = true;
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), () -> {
            switch (seconds) {
                case 60: case 30: case 15: case 10: case 5: case 4: case 3: case 2:
                    Bukkit.broadcastMessage(Main.getPrefix() + "Das Spiel beginnt in §a" + seconds + " §7Sekunden!");
                    if(seconds == 3)
                        isStarting = true;
                    break;
                case 1:
                    Bukkit.broadcastMessage(Main.getPrefix() + "Das Spiel beginnt in §aeiner §7Sekunde!");
                    break;
                case 0:
                    Main.getGameStateManager().setGameState(GameState.INGAME_STATE);
                    break;
                    default:
                        break;
            }

            seconds--;
        },0, 20);
    }

    @Override
    public void cancel() {
        isRunning = false;

        Bukkit.getScheduler().cancelTask(taskID);
        seconds = RESET_SECONDS;
    }

    public void idle() {
        isIdling = true;

        idleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), () -> {
            int missingPlayers = LobbyState.MIN_PLAYERS - Main.getPlugin().getPlayers().size();
            if(missingPlayers != 1)
                Bukkit.broadcastMessage(Main.getPrefix() + "Es fehlen noch §c" + missingPlayers + " §7Spieler bis zum Start.");
            else
                Bukkit.broadcastMessage(Main.getPrefix() + "Es fehlt noch §cein §7Spieler bis zum Start.");
        }, IDLE_SECONDS * 20, IDLE_SECONDS * 20);
    }

    public void cancelIdle() {
        isIdling = false;

        Bukkit.getScheduler().cancelTask(idleID);
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setStarting(boolean starting) {
        isStarting = starting;
    }

    public boolean isStarting() {
        return isStarting;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isIdling() {
        return isIdling;
    }
}
