package APCSA.FRQ._2022;

/**
 * This is traverse of 2-Dim Array and random() method practice
 * 
 * @author esmondjeng
 */
public class FrqAns2022Q4 {
	public static void main(String[] args) {
		Data d = new Data(3, 15, -1);
		d.print2D();
		// Test for 2022 FRQ 4.(a)
		d.repopulate();
		d.print2D();
		
		// Test for 2022 FRQ 4.(b)
		int increaseCount = d.countIncreasingCols();
		System.out.println("Counted Increase Columns: " + increaseCount);
	}

}

class Data {
	public static final int MAX = 500;/* value not shown */;
	private int[][] grid;

	// Construct to build 2-Dim m*n elemenets
	public Data(int m, int n, int initialVal) {
		grid = new int[m][n];
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++) {
				this.grid[i][j] = initialVal;
			}
		}
	}

	/**
	 * Fills all elements of grid with randomly generated values, as described in
	 * part (a) 
	 * Precondition: grid is not null. grid has at least one element.
	 */
	// Answer for 2022 FRQ 4.(a)
	public void repopulate() {
		/* Horizontal Traverse of grid[][] */
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++) {
				int randNum = 7777;
				/*
				 * 放大 (int)(Math.random()*n)) // 0~(n-1) 平移 (int)(Math.random()*n))+k //
				 * k~(n-1)+k Loop until meet divided by 10 and NOT divided by 100
				 */
				while (randNum % 10 != 0 || randNum % 100 == 0) {
					randNum = (int) (Math.random() * 500 + 1);
				}

				/* Assign 1 <= random number <= MAX to 2-Dim element */
				this.grid[i][j] = randNum;
			}
		}
	}

	/**
	 * Returns the number of columns in grid that are in increasing order, as
	 * described in part (b) 
	 * Precondition: grid is not null. grid has at least one
	 * element.
	 */
	// Answer for 2022 FRQ 4.(b)
	public int countIncreasingCols() {
		/* to be implemented in part (b) */
		int count = 0;
		boolean foundCol = false;
		// Vertical Traverse
		for (int j = 0; j < this.grid[0].length; j++) {
			foundCol = false;
			for (int i = 1; i < this.grid.length; i++) {
				if (this.grid[i][j] > this.grid[i-1][j]) {
					foundCol = true; // Yes, Next element
				} else {
					foundCol = false; // No
					break; // Next column
				}
			}
			if (foundCol == true) {
				count = count + 1;
				System.out.println("Col: " + j);
			}
		}

		return count;
	}

	public void print2D() {
		for (int i = 0; i < this.grid.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < this.grid[i].length; j++) {
				System.out.printf("%3d ", this.grid[i][j]);
			}
			System.out.println("]");
		}
		System.out.println();
	}
}