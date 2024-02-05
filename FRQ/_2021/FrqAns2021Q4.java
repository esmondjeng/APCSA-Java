package APCSA.FRQ._2021;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2021Q4 {
	public static void main(String[] args) {
		int[][] arr2D1 = {
				{0, 1, 2, 8},
				{1, 2, 8, 0},
				{2, 8, 0, 1},
				{8, 0, 1, 2},
				{7, 7, 7, 7},
				{8, 8, 8, 8},
				{9, 9, 9, 9},
				{6, 6, 6, 6},
				};
		int[][] arr2D2 = { 
				{8, 3, 9}, 
				{0, 0, 1}, 
				{0, 2, 1}, 
				{1, 0, 0}, 
				{0, 0, 1}, 
				{3, 1, 7}, 
				{0, 1, 0},
				{1, 2, 1} 
		};
		// Test for 2021 FRQ 4.(a)
		System.out.println(ArrayResizer.isNonZeroRow(arr2D1, 0));
		System.out.println(ArrayResizer.isNonZeroRow(arr2D1, 4));
		System.out.println(ArrayResizer.numNonZeroRows(arr2D1));
		System.out.println(ArrayResizer.numNonZeroRows(arr2D2));
		System.out.println("**********");
		System.out.println();

		// Test for 2021 FRQ 4.(b)
		int[][] temp1 = ArrayResizer.resize(arr2D1);
		int[][] temp2 = ArrayResizer.resize(arr2D2);
		ArrayResizer.display2D(arr2D1);
		System.out.println("**********");
		ArrayResizer.display2D(temp1);
		System.out.println("**********");
		ArrayResizer.display2D(arr2D2);
		System.out.println("**********");
		ArrayResizer.display2D(temp2);
		System.out.println("**********");
	}
}

class ArrayResizer {

	/**
	 * Returns true if and only if every value in row r of array2D is non-zero.
	 * Precondition: r is a valid row index in array2D. 
	 * Postcondition: array2D is unchanged.
	 */
	// Answer for 2021 FRQ 4.(a)
	public static boolean isNonZeroRow(int[][] array2D, int r) {
		int i = r;
		for(int j=0; j<array2D[i].length; j++) {
			if(array2D[i][j]==0)
				return false; // Once zero return false
		}
		return true; // All non-zeros return true
	}

	/**
	 * Returns the number of rows in array2D that contain all non-zero values.
	 * Postcondition: array2D is unchanged.
	 */
	public static int numNonZeroRows(int[][] array2D) {
		int count = 0;
		for (int i=0; i<array2D.length;i++) {
			if(isNonZeroRow(array2D, i))
				count++;
		}
		return count;
	}

	/**
	 * Returns a new, possibly smaller, two-dimensional array that contains only
	 * rows from array2D with no zeros, as described in part (b). 
	 * Precondition: array2D contains at least one column and at least one row with no zeros.
	 * Postcondition: array2D is unchanged.
	 */
	// Answer for 2021 FRQ 4.(b)
	public static int[][] resize(int[][] array2D) {
		ArrayList<Integer> nonZeroRow = new ArrayList<Integer>();
		int count = 0;
		for (int i=0; i<array2D.length;i++) {
			if(isNonZeroRow(array2D, i)) {
				nonZeroRow.add(i);
				count++;
			}
		}
		
		int[][] temp = new int[count][array2D[0].length];
		for (int i=0; i<count;i++) {
			temp[i] = array2D[nonZeroRow.get(i)];
		}
		return temp;
	}
	
	public static void display2D(int[][] data) {
		for (int[] row: data) {
			for (int element: row) {
					System.out.printf("%2d, ", element);
			}
			System.out.println(); // Row conclusion or house cleaning
		}
	}
}
