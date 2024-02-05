package APCSA.FRQ._2007;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2007Q4 {
	public static void main(String[] args) {
		// Test for 2007 FRQ 4.(a)
		Player p1 = new RandomPlayer("X");
		Player p2 = new RandomPlayer("O");
		Player[] playerList = {p1, p2};
		
		ArrayList<String> moves = new ArrayList<String>();
		moves.add("1-1");
		moves.add("1-2");
		moves.add("1-3");
		moves.add("2-1");
		moves.add("2-2");
		moves.add("2-3");
		moves.add("3-1");
		moves.add("3-2");
		moves.add("3-3");
		
		GameStateX game = new GameStateX(playerList, moves);
		System.out.println(game);
		System.out.println("**********");
		
		// Test for 2007 FRQ 4.(b)
		GameDriver gr = new GameDriver(game);
		gr.play();
	}
}

interface GameState {
	/**
	 * @return true if the game is in an ending state; false otherwise
	 */
	boolean isGameOver();

	/**
	 * Precondition: isGameOver() returns true
	 * 
	 * @return the player that won the game or null if there was no winner
	 */
	Player getWinner();

	/**
	 * Precondition: isGameOver() returns false
	 * 
	 * @return the player who is to make the next move
	 */
	Player getCurrentPlayer();

	/**
	 * @return a list of valid moves for the current player; the size of the
	 *         returned list is 0 if there are no valid moves.
	 */
	ArrayList<String> getCurrentMoves();

	/**
	 * Updates game state to reflect the effect of the specified move.
	 * 
	 * @param move a description of the move to be made
	 */
	void makeMove(String move);

	/**
	 * @return a string representing the current GameState
	 */
	String toString();
}

class GameStateX implements GameState {
	Player winner;
	Player currentPlayer;
	ArrayList<String> moves; // Pre-defined all the moves while instantiate object
	boolean gameOver;
	Player[] playerList; // ALways two player [0] & [1]
	
	public GameStateX(Player[] playerList, ArrayList<String> moves) {
		this.winner = null;
		this.currentPlayer = playerList[(int)(Math.random()+0.5)];
		this.moves = moves;
		this.gameOver = false;
		this.playerList = playerList;
	}
	
	@Override
	public boolean isGameOver() {
		return this.gameOver;
	}

	@Override
	public Player getWinner() {
		return this.currentPlayer;
	}

	@Override
	// May alternatively change players
	public Player getCurrentPlayer() {
		if (this.currentPlayer.equals(this.playerList[0])) {
			this.currentPlayer = this.playerList[1];
			return this.playerList[1];
		} else {
			this.currentPlayer = this.playerList[0];
			return this.playerList[0];
		}
	}

	@Override
	public ArrayList<String> getCurrentMoves() {
		return this.moves;
	}

	@Override
	// remove one move from beginning ArrayList moves until empty
	public void makeMove(String move) {
		this.moves.remove(move); // plus mark player status
		if (moves.isEmpty()) {
			this.gameOver = true; // checkOver();
			this.winner = this.currentPlayer; // checkWinner()
		}
	}
	
	@Override
	public String toString() {
		return String.format("Winner: %s; Current: %s;\nSteps: %s\n", this.winner, this.currentPlayer, this.moves);
	};
}

class Player {
	private String name; // name of this player

	public Player(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * This implementation chooses the first valid move. Override this method in
	 * subclasses to define players with other strategies.
	 * 
	 * @param state the current state of the game; its current player is this
	 *              player.
	 * @return a string representing the move chosen; "no move" if no valid moves
	 *         for the current player.
	 */

	public String getNextMove(GameState state) {
		int size = state.getCurrentMoves().size();
		if (size == 0)
			return "no move";
		else
			return state.getCurrentMoves().get(0);
	}
	
	public String toString() {
		return getName();
	}
}

//Answer for 2007 FRQ 4.(a)
class RandomPlayer extends Player {
	public RandomPlayer(String aName) {
		super(aName);
	}

	public String getNextMove(GameState state) {
		ArrayList<String> possibleMoves = state.getCurrentMoves(); // All moves
		int size = possibleMoves.size(); // Size of possible moves
		if (size == 0) {
			return "no move";
		} else {
			int randomIndex = (int) (Math.random() * size);
			return possibleMoves.get(randomIndex);
		}
	}
}

class GameDriver {
	private GameState state; // the current state of the game

	public GameDriver(GameState initial) {
		this.state = initial;
	}

	/**
	 * Plays an entire game, as described in the problem description
	 */
	// Answer for 2007 FRQ 4.(b)
	public void play() {
		System.out.println("Initial state:" + state);
		
		while (!state.isGameOver()) {
			Player currPlayer = state.getCurrentPlayer();
			String currMove = currPlayer.getNextMove(state);
			System.out.println(currPlayer.getName() + ": " + currMove);
			state.makeMove(currMove);
		}
		
		Player winner = state.getWinner();
		if (winner != null) {
			System.out.println(winner.getName() + " wins");
		} else {
			System.out.println("Game ends in a draw");
		}
	}
}
