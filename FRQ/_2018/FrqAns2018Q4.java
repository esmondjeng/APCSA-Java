package APCSA.FRQ._2018;

/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.Arrays;

public class FrqAns2018Q4 {
	public static void main(String[] args) {
		int[][] arr2D = { { 0, 1, 2 }, { 2, 1, 0 }, { 5, 7, 8 }, { 8, 5, 5 } };
		print2D(arr2D);
		System.out.printf("Row 0 has duplicates: %b\n", ArrayTester.containsDuplicates(arr2D[0]));
		System.out.printf("Row 1 has duplicates: %b\n", ArrayTester.containsDuplicates(arr2D[1]));
		System.out.printf("Row 2 has duplicates: %b\n", ArrayTester.containsDuplicates(arr2D[2]));
		System.out.printf("Row 3 has duplicates: %b\n", ArrayTester.containsDuplicates(arr2D[3]));
		System.out.printf("Row 0 & Row 1 overlap: %b\n", ArrayTester.hasAllValues(arr2D[0], arr2D[1]));
		System.out.printf("Row 2 & Row 3 overlap: %b\n", ArrayTester.hasAllValues(arr2D[2], arr2D[3]));
		System.out.printf("Column 0 & Column 2 overlap: %b\n",
				ArrayTester.hasAllValues(ArrayTester.getColumn(arr2D, 0), ArrayTester.getColumn(arr2D, 2)));
		System.out.printf("Column 0 & Column 1 overlap: %b\n",
				ArrayTester.hasAllValues(ArrayTester.getColumn(arr2D, 0), ArrayTester.getColumn(arr2D, 1)));
		System.out.printf("Column 1 & Column 2 overlap: %b\n",
				ArrayTester.hasAllValues(ArrayTester.getColumn(arr2D, 1), ArrayTester.getColumn(arr2D, 2)));
		System.out.println("**********");

		// Test for 2018 FRQ 4.(a)
		print2D(arr2D);
		int[] result0 = ArrayTester.getColumn(arr2D, 0);
		System.out.println(Arrays.toString(result0));
		int[] result1 = ArrayTester.getColumn(arr2D, 1);
		System.out.println(Arrays.toString(result1));
		int[] result2 = ArrayTester.getColumn(arr2D, 2);
		System.out.println(Arrays.toString(result2));
		System.out.println("**********");

		// Test for 2018 FRQ 4.(b)
		int[][] one2D = { { 0, 1, 2, 4 }, { 1, 2, 4, 0 }, { 2, 4, 0, 1 }, { 4, 0, 1, 2 } };
		print2D(one2D);
		System.out.println(ArrayTester.isLatin(one2D));
		System.out.println(ArrayTester.isLatin2(one2D));
		int[][] two2D = { { 0, 1, 2, 4 }, { 1, 2, 4, 0 }, { 4, 0, 1, 2 }, { 2, 4, 0, 1 } };
		print2D(two2D);
		System.out.println(ArrayTester.isLatin(two2D));
		System.out.println(ArrayTester.isLatin2(two2D));
		int[][] three2D = { { 0, 1, 2, 4 }, { 1, 2, 4, 0 }, { 4, 0, 1, 2 }, { 0, 4, 2, 1 } };
		print2D(three2D);
		System.out.println(ArrayTester.isLatin(three2D));
		System.out.println(ArrayTester.isLatin2(three2D));
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

class ArrayTester {
	/**
	 * Returns an array containing the elements of column c of arr2D in the same
	 * order as they appear in arr2D. Precondition: c is a valid column index in
	 * arr2D. Postcondition: arr2D is unchanged.
	 */
	// Answer for 2018 FRQ 4.(a)
	public static int[] getColumn(int[][] arr2D, int c) {
		int[] result = new int[arr2D.length];
		for (int i = 0; i < arr2D.length; i++) {
			result[i] = arr2D[i][c];
		}
		return result;
	}

	/**
	 * Returns true if and only if every value in arr1 appears in arr2.
	 * Precondition: arr1 and arr2 have the same length. Postcondition: arr1 and
	 * arr2 are unchanged.
	 */
	public static boolean hasAllValues(int[] arr1, int[] arr2) {
		int countAll = 0;
		int countIn = 0;
		for (int i = 0; i < arr1.length; i++) {
			countIn = 0;
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j])
					countIn++;
			}
			if (countIn > 0)
				countAll++;
		}
		if (countAll >= arr1.length)
			return true;
		else
			return false;
	}

	/**
	 * Returns true if arr contains any duplicate values; false otherwise.
	 */
	public static boolean containsDuplicates(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					// DEBUG: System.out.println("Count: " + count);
					count++;
				}
			}
		}
		if (count > 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns true if square is a Latin square as described in part (b); false
	 * otherwise. Precondition: square has an equal number of rows and columns.
	 * square has at least one row.
	 */
	// Answer for 2018 FRQ 4.(b)
	public static boolean isLatin(int[][] square) {
		if (containsDuplicates(square[0])) {
			return false;
		}
		for (int r = 1; r < square.length; r++) {
			if (!hasAllValues(square[0], square[r])) {
				return false;
			}
		}
		for (int c = 0; c < square[0].length; c++) {
			if (!hasAllValues(square[0], getColumn(square, c))) {
				return false;
			}
		}
		return true;
	}
	// Optional Answer for 2018 FRQ 4.(b)
	public static boolean isLatin2(int[][] square) {
		for (int i = 0; i < square.length; i++) {
			if (containsDuplicates(square[i])) {
				// DEBUG: System.out.printf("Row %d contain duplicates.\n", i);
				return false;
			}
		}
		for (int i = 0; i < square.length; i++) {
			for (int j = i; j < square.length; j++) {
				if (!hasAllValues(square[i], square[j])) {
					// DEBUG: System.out.printf("Row %d & Row %d is inconsistent.\n", i, j);
					return false;
				}
			}
		}
		for (int j = 0; j < square[0].length; j++) {
			for (int i = j; i < square[0].length; i++) {
				if (!hasAllValues(getColumn(square, j), getColumn(square, i))) {
					// DEBUG: System.out.printf("Column %d & Column %d is inconsistent.\n", j, i);
					return false;
				}
			}
		}
		return true;
	}


}
