package APCSA.FRQ._2019;

/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2019Q4 {
	public static void main(String[] args) {
		int[][] l = { { 1, 1, 0, 1, 1 }, 
				{ 1, 0, 0, 1, 0 }, 
				{ 1, 0, 0, 1, 1 }, 
				{ 1, 0, 0, 0, 1 }, 
				{ 1, 0, 0, 0, 1 },
				{ 1, 1, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 0 } };
		print2D(l);
		System.out.println();

		// Test for 2019 FRQ 4.(a)
		LightBoard lightEsmond = new LightBoard(l.length, l[0].length);
		lightEsmond.display();
		System.out.println();

		// Test for 2019 FRQ 4.(b)
		// lightEsmond.fillLight(l);
		// lightEsmond.display();
		// System.out.println();
		System.out.println(lightEsmond.evaluateLight(2, 3));
		System.out.println();
		lightEsmond.display();
	}

	public static void print2D(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + ", ");
			}
			System.out.println();
		}
		return;
	}
}

class LightBoard {
	/**
	 * The lights on the board, where true represents on and false represents off.
	 */
	private boolean[][] lights;

	/**
	 * Constructs a LightBoard object having numRows rows and numCols columns.
	 * Precondition: numRows > 0, numCols > 0 Postcondition: each light has a 40%
	 * probability of being set to on.
	 */
	// Answer for 2019 FRQ 4.(a)
	public LightBoard(int numRows, int numCols) { // Construct
		boolean[][] l = new boolean[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				double chance = Math.random();
				if (chance <= 0.4)
					l[i][j] = true;
				else
					l[i][j] = false;
			}
		}
		// Assign created 2-dim array l's pointer to property lights
		this.lights = l;
	}

	/**
	 * Evaluates a light in row index row and column index col and returns a status
	 * as described in part (b). 
	 * Precondition: row and col are valid indexes in lights.
	 */
	// Answer for 2019 FRQ 4.(b)
	public boolean evaluateLight(int row, int col) {
		int numOn = 0;

		for (int r = 0; r < lights.length; r++) {
			if (lights[r][col]) { // Count true in vertical column
				numOn++;
			}
		}

		if (lights[row][col] && numOn % 2 == 0) {
			return false;
		}
		if (!lights[row][col] && numOn % 3 == 0) {
			return true;
		}
		return lights[row][col];
	}

	public void fillLight(int[][] l) {
		for (int i = 0; i < this.lights.length; i++) {
			for (int j = 0; j < this.lights[i].length; j++) {
				this.lights[i][j] = (l[i][j] == 1 ? true : false);
			}
		}
	}

	public void display() {
		for (int i = 0; i < this.lights.length; i++) {
			for (int j = 0; j < this.lights[i].length; j++) {
				System.out.printf("%-5b, ", lights[i][j]);
			}
			System.out.println();
		}
		return;
	}
}