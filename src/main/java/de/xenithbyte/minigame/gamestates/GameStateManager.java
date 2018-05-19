package de.xenithbyte.minigame.gamestates;

public class GameStateManager {

    private GameState[] gameStates = new GameState[3];
    private GameState currentGameState;

    public GameStateManager() {
        gameStates[GameState.LOBBY_STATE] = new LobbyState();
        gameStates[GameState.INGAME_STATE] = new IngameState();
        gameStates[GameState.ENDING_STATE] = new EndingState();
    }

    public void setGameState(int gameStateIndex) {
        if(currentGameState != null)
            currentGameState.stop();
        currentGameState = gameStates[gameStateIndex];
        currentGameState.start();
    }

    public void stopCurrentGameState() {
        currentGameState.stop();
        currentGameState = null;
    }

}
