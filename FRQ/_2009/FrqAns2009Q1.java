package APCSA.FRQ._2009;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.Arrays;

public class FrqAns2009Q1 {
	public static void main(String[] args) {
		NumberCube temp = new NumberCube();
		// Test for 2009 FRQ 1.(a)
		int[] tossValues = getCubeTosses(temp, 20);
		System.out.println(Arrays.toString(tossValues));
		System.out.println("**********");
		
		// Test for 2009 FRQ 1.(b)
		int[] testValues1 = { 1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5, 2, 1 };
		System.out.println(Arrays.toString(testValues1));
		System.out.println("Max Run Index is: " + getLongestRun(testValues1));
		int[] testValues2 = { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5, 2, 1 };
		System.out.println(Arrays.toString(testValues2));
		System.out.println("Max Run Index is: " + getLongestRun(testValues2));
		int[] testValues3 = { 1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 2, 2, 3, 3, 5, 5, 5, 5, 2, 1 };
		System.out.println(Arrays.toString(testValues3));
		System.out.println("Max Run Index is: " + getLongestRun(testValues3));

		System.exit(0);
	} // End of main()

	/**
	 * Returns an array of the values obtained by tossing a number cube numTosses
	 * times.
	 * 
	 * @param cube      a NumberCube
	 * @param numTosses the number of tosses to be recorded Precondition: numTosses
	 *                  > 0
	 * @return an array of numTosses values
	 */
	// Answer for 2009 FRQ 1.(a)
	public static int[] getCubeTosses(NumberCube cube, int numTosses) {
		int[] tossValues = new int[numTosses];
		for (int i = 0; i < tossValues.length; i++) {
			tossValues[i] = cube.toss();
		}
		return tossValues;
	} // End of getCubeTosses()

	/**
	 * Returns the starting index of a longest run of two or more consecutive
	 * repeated values in the array values.
	 * 
	 * @param values an array of integer values representing a series of number cube
	 *               tosses Precondition: values.length > 0
	 * @return the starting index of a run of maximum size; -1 if there is no run
	 */
	// Answer for 2009 FRQ 1.(b)
	public static int getLongestRun(int[] values) {
		int maxIndex = -1;
		int maxRun = 1;
		int tempRun = 1;
		int i = 0;
		// Jump along the array
		while (i < values.length) { // Loop from 0~values.length-1
			// Move along the array after i one by one to compare until unmatched
			for (int j = i + 1; j < values.length; j++) {
				// If currentMax == afterwards, matched
				if (values[j] == values[i]) {
					tempRun++;
				} else { // unmatched
					break;
				}
			}
			System.out.printf("i = %d; Value = %d; Run = %d\n", i, values[i], tempRun);
			// If new matched is found, store temp Run to max Run
			if (tempRun >= maxRun) {
				maxIndex = i;
				maxRun = tempRun;
				System.out.printf("**Max Run index = %d; Value = %d; Max Runs=%d\n", maxIndex, values[maxIndex], maxRun);
			}
			
			// Reset index for next run
			i = i + tempRun;
			tempRun = 1;
		}
		return maxIndex;
	} // End of getLongestRun()
} // End of FrqAns2009Q1 class

// The test is to define Class with class methods
class NumberCube {
	/**
	 * @return an integer value between 1 and 6, inclusive
	 */
	public int toss() {
		return (int) (Math.random() * 5.0) + 1;
	}
}