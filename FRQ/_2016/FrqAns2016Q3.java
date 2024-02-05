package APCSA.FRQ._2016;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2016Q3 {
	public static void main(String[] args) {
		// DEBUG: Square s1 = new Square(true, 0);
		// DEBUG: Square s2 = new Square(false, 2);
		// DEBUG: System.out.println(s1);
		// DEBUG: System.out.println(s2);
		boolean[][] maze = {{true, false, false, true, true, true, false, false, false},
							{false, false, false, false, true, false, false, false, false},
							{false, false, false, false, false, false, true, true, true},
							{false, false, true, false, false, false, true, false, false},
							{true, true, true, false, false, false, false, false, false},
							{false, false, false, false, true, false, false, false, false},
							{false, false, false, true, true, true, false, false, true}};
		print2D(maze);
		System.out.println("*********************");
		
		// Test for 2016 FRQ 3.(b) & 2016 FRQ 3.(b) both
		Crossword cw = new Crossword(maze);
		cw.display();
	}
	
	public static void print2D(boolean[][] data) {
		for(int i=0; i < data.length; i++) {
			for(int j=0; j < data[i].length; j++) {
				System.out.print((data[i][j]?"Black":"White") + ", ");
			}
			System.out.println();
		}
		return;
	}
}

class Square {
	private boolean isBlack; // true: Black; false:White
	private int num;
	/**
	 * Constructs one square of a crossword puzzle grid.
	 * Postcondition: - The square is black if and only if 
	 * isBlack is true. - The square has number num.
	 */
	public Square(boolean isBlack, int num) {
		this.isBlack = isBlack;
		this.num = num;
	}
	
	public String toString() {
		return String.format("%s (%2d)", (this.isBlack? "Black":"White"), this.num);
	}
}

class Crossword {
	/**
	 * Each element is a Square object with a color (black or white) 
	 * and a number.
	 * puzzle[r][c] represents the square in row r, column c. 
	 * There is at least one row in the puzzle.
	 */
	private Square[][] puzzle;

	/**
	 * Constructs a crossword puzzle grid. Precondition: There is 
	 * at least one row n blackSquares.
	 * Postcondition: 
	 * - The crossword puzzle grid has the same dimensions as blackSquares. 
	 * - The Square object at row r, column c in the crossword puzzle grid 
	 * is black if and only if blackSquares[r][c] is true. 
	 * - The squares in the puzzle are labeled according to the crossword labeling
	 * rule.
	 */
	// Answer for 2016 FRQ 3.(b)
	public Crossword(boolean[][] blackSquares) {
		puzzle = new Square[blackSquares.length][blackSquares[0].length];
		int num = 1;
		for (int r = 0; r < blackSquares.length; r++) {
			for (int c = 0; c < blackSquares[0].length; c++) {
				if (blackSquares[r][c]) {
					puzzle[r][c] = new Square(true, 0);
				} else {
					if (toBeLabeled(r, c, blackSquares)) {
						puzzle[r][c] = new Square(false, num);
						num++;
					} else {
						puzzle[r][c] = new Square(false, 0);
					}
				}
			}
		}
	}

	/**
	 * Returns true if the square at row r, column c should be labeled with a
	 * positive number; false otherwise. The square at row r, column c is black if
	 * and only if blackSquares[r][c] is true. Precondition: r and c are valid
	 * indexes in blackSquares.
	 */
	// Answer for 2016 FRQ 3.(a)
	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
		return (!(blackSquares[r][c]) && (r == 0 || c == 0 || blackSquares[r - 1][c] || blackSquares[r][c - 1]));
	}
	
	public void display() {
		for(int i=0; i < puzzle.length; i++) {
			for(int j=0; j < puzzle[i].length; j++) {
				System.out.print(puzzle[i][j] + ", ");
			}
			System.out.println();
		}
		return;
	}
}