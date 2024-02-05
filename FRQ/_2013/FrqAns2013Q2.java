package APCSA.FRQ._2013;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2013Q2 {

	public static void main(String[] args) {
		// Test for 2013 FRQ 2.(a) random number
		TokenPass t = new TokenPass(6);
		System.out.println(t);
		// Test for 2013 FRQ 2.(b) random number
		t.distributeCurrentPlayerTokens();
		System.out.println(t);
	}

}

class TokenPass {
	private int[] board;
	private int currentPlayer;

	/**
	 * Creates the board array to be of size playerCount and fills it with random
	 * integer values from 1 to 10, inclusive. Initializes currentPlayer to a random
	 * integer value in the range between 0 and playerCount-1, inclusive.
	 * 
	 * @param playerCount the number of players
	 */
	// Answer for 2013 FRQ 2.(a) random number
	public TokenPass(int playerCount) {
		this.board = new int[playerCount];
		for (int i=0; i < this.board.length; i++)
			this.board[i] = (int) (Math.random()*9) + 1;
		this.currentPlayer = (int) (Math.random()*(playerCount));
	}

	/**
	 * Distributes the tokens from the current player's position one at a time to
	 * each player in the game. Distribution begins with the next position and
	 * continues until all the tokens have been distributed. If there are still
	 * tokens to distribute when the player at the highest position is reached, the
	 * next token will be distributed to the player at position 0. 
	 * 
	 * Precondition: the current player has at least one token. 
	 * Postcondition: the current player has not changed.
	 */
	// Answer for 2013 FRQ 2.(b)
	public void distributeCurrentPlayerTokens() {
		/* to be implemented in part (b) */
		int n = board[currentPlayer];
		board[currentPlayer] = 0;
		for (int i=currentPlayer+1; i < board.length; i++) {
			if (n > 0) {
				board[i] = board[i] +1;
				n--;
			}
		}
		while (n > 0) {
			for (int i=0; i < board.length; i++) {
				if (n > 0) {
					board[i] = board[i] +1;
					n--;
				}
			}	
		}
	}

	@Override
	public String toString() {
		String str="";
		for(int b: this.board) {
			str = str + b + ";";
		}
		str = str + "Current Player: " + this.currentPlayer;
		return str;
	}
}