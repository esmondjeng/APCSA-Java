package APCSA.FRQ._2009;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2009Q4 {
	public static void main(String[] args) {
		// Test for 2009 FRQ 4.(a)
		NumberTile t0 = new NumberTile(4, 3, 7, 4);
		NumberTile t1 = new NumberTile(6, 4, 3, 3);
		NumberTile t2 = new NumberTile(1, 2, 3, 4);
		NumberTile t3 = new NumberTile(3, 2, 5, 2);
		NumberTile t4 = new NumberTile(5, 9, 2, 2);
		System.out.println(t0);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println("***************");
		NumberTile test1 = new NumberTile(4, 3, 7, 4);
		System.out.println(test1);
		test1.rotate();
		System.out.println(test1);
		System.out.println("***************");
		
		// Test for 2009 FRQ 4.(a)
		// Test for 2009 FRQ 4.(b)
		TileGame game = new TileGame();
		System.out.println(game.getIndexForFit(t0));
		game.insertTile(t0);
		game.display();
		System.out.println(game.getIndexForFit(t1));
		game.insertTile(t1);
		game.display();
		System.out.println(game.getIndexForFit(t2));
		game.insertTile(t2);
		game.display();
		System.out.println(game.getIndexForFit(t3));
		game.insertTile(t3);
		game.display();
		System.out.println(game.getIndexForFit(t4));
		game.insertTile(t4);
		game.display();
		
		// Test for 2009 FRQ 4.(a)
		NumberTile test2 = new NumberTile(4, 2, 9, 2);
		System.out.println(game.getIndexForFit(test2));
		// Test for 2009 FRQ 4.(b)
		game.insertTile(test2);
		game.display();
	}
}

class NumberTile {
	int[] tile = new int[4]; // 0-upper, 1-right, 2-down, 3-left
	final int UPPER = 0;
	final int RIGHT = 1;
	final int DOWN = 2;
	final int LEFT = 3;
	
	public NumberTile(int u, int r, int d, int l) {
		this.tile[UPPER] = u;
		this.tile[RIGHT] = r;
		this.tile[DOWN] = d;
		this.tile[LEFT] = l;
	}
	
	/**
	 * Rotates the tile 90 degrees clockwise
	 */
	public void rotate() {
		int[] temp = new int[4];
		temp[0] = this.tile[this.tile.length-1];
		for (int i=1; i < this.tile.length; i++)
			temp[i] = this.tile[i-1];
		this.tile = temp;
	}
	/**
	 * @return value at left edge of tile
	 */
	public int getLeft() {
		return this.tile[LEFT];
	}

	/**
	 * @return value at right edge of tile
	 */
	public int getRight() {
		return this.tile[RIGHT];
	}
	
	public String toString() {
		return String.format("   Upper-%d\nLeft-%d Right-%d\n   Down-%d", 
				tile[UPPER], tile[LEFT], tile[RIGHT], tile[DOWN]);
	}
}

class TileGame {
	/** represents the game board; guaranteed never to be null */
	private ArrayList<NumberTile> board;

	public TileGame() {
		board = new ArrayList<NumberTile>();
	}

	/**
	 * Determines where to insert tile, in its current orientation, into game board
	 * 
	 * @param tile the tile to be placed on the game board
	 * @return the position of tile where tile is to be inserted: 0 if the board is
	 *         empty; -1 if tile does not fit in front, at end, or between any
	 *         existing tiles; otherwise, 0 ≤ position returned ≤ board.size()
	 */
	// Answer for 2009 FRQ 1.(a)
	/*
	 * Logic Structure is to separate logics for ArrayList.size=0, 1, >1
	 */
	public int getIndexForFit(NumberTile tile) {
		int size = this.board.size();
		int first = 0;
		int last = size-1;
		int end = last+1;
		int noPlace = -1;
		// Check if put in the middle
		if(size > 1) { // board.size > 1 in else logic
			for (int i=1; i < (this.board.size()-1); i++) {
				int middleLeft = i;
				int middleRight = i+1;
				if(this.board.get(middleLeft).getRight()==tile.getLeft() && this.board.get(middleRight).getLeft()==tile.getRight()) {
					return middleRight;
				}
			}
		}
		
		if(size==0) // board.size=0, empty board, put into directly.
			return first;
		// Until here, size = 1 && size > 1 but no insert
		// Check if put in the end
		if(this.board.get(last).getRight()==tile.getLeft())
			return end; //

		// Check if put in the front
		if(this.board.get(0).getLeft()==tile.getRight())
			return first;
		
		return noPlace; // None of above fits (Front, End, Middle).
	}

	/**
	 * Places tile on the game board if it fits (checking all possible tile
	 * orientations if necessary). If there are no tiles on the game board, the tile
	 * is placed at position 0. The tile should be placed at most 1 time.
	 * Precondition: board is not null
	 * 
	 * @param tile the tile to be placed on the game board
	 * @return true if tile is placed successfully; false otherwise
	 * 
	 * Postcondition:
	 *         the orientations of the other tiles on the board are not changed
	 *         Postcondition: the order of the other tiles on the board relative to
	 *         each other is not changed
	 */
	// Answer for 2009 FRQ 1.(b)
	public boolean insertTile(NumberTile tile) {
		if(this.board.size()==0) {
			this.board.add(tile);
			return true;
		}
		
		for (int i=1; i <= 4; i++) { // Rotate 3 times at most, loop 1~1+3
			int index = getIndexForFit(tile);
			if(index != -1) {
				if (index == this.board.size())
					this.board.add(tile); // Add to behind last
				else
					this.board.add(index, tile); // Insert into middle or front
				return true;
			} else {
				tile.rotate(); // rotate to next angle 90-180-270 until no fit
			}
		}
		return false;
	}
	
	public void display() {
		System.out.println("*****Beginning of TileGame*****");
		for(NumberTile element : board)
			System.out.println(element);
		System.out.println("*****End of TileGame*****");
	}
}