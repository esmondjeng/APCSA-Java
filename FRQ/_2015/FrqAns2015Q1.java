package APCSA.FRQ._2015;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.Arrays;

public class FrqAns2015Q1 {
	public static void main(String[] args) {
		// Test for 2015 FRQ 1.(a)
		int[] arr1 = {1, 3, 2, 7, 3};
		System.out.println(Lib2015Q1.arraySum(arr1));
		
		// Test for 2015 FRQ 1.(b)
		int[][] mat1 = {{1,3,2,7,3},{10,10,4,6,2},
						{5,3,5,9,6},{7,6,4,2,1}};
		int[][] mat2 = {{1,1,5,3,4},{12,7,6,1,9},
						{8,11,10,2,5},{3,2,3,0,6}};
		arr1 = Lib2015Q1.rowSums(mat1);
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = Lib2015Q1.rowSums(mat2);
		System.out.println(Arrays.toString(arr2));
		
		// Test for 2015 FRQ 1.(c)
		System.out.println(Lib2015Q1.isDiverse(mat1)); // true
		System.out.println(Lib2015Q1.isDiverse(mat2)); // false
	}
}

class Lib2015Q1 {
	// Answer for 2015 FRQ 1.(a)
	public static int arraySum(int[] arr) {
		int sum = 0;
		for (int elem : arr) {
			sum += elem;
		}
		return sum;
	}

	// Answer for 2015 FRQ 1.(b)
	public static int[] rowSums(int[][] arr2D) {
		int[] sums = new int[arr2D.length];
		int rowNum = 0;
		for (int[] row : arr2D) {
			sums[rowNum] = arraySum(row);
			rowNum++;
		}
		return sums;
	}

	// Answer for 2015 FRQ 1.(c)
	public static boolean isDiverse(int[][] arr2D) {
		int[] sums = rowSums(arr2D);
		for (int i = 0; i < sums.length; i++) {
			for (int j = i + 1; j < sums.length; j++) {
				if (sums[i] == sums[j]) {
					return false;
				}
			}
		}
		return true;
	}
}