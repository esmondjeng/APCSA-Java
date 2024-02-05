package APCSA.FRQ._2007;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2007Q1 {
	public static void main(String[] args) {
		// Test for 2007 FRQ 1.(a)
		System.out.println(SelfDivisor.isSelfDivisor(128));
		System.out.println(SelfDivisor.isSelfDivisor(124));
		System.out.println(SelfDivisor.isSelfDivisor(115));
		System.out.println(SelfDivisor.isSelfDivisor(777));
		System.out.println(SelfDivisor.isSelfDivisor(789));
		System.out.println(SelfDivisor.isSelfDivisor(200));
		System.out.println("**********");
		
		// Test for 2007 FRQ 1.(b)
		int[] r1 = SelfDivisor.firstNumSelfDivisors(10, 3);
		SelfDivisor.print1d(r1);
		int[] r2 = SelfDivisor.firstNumSelfDivisors(113, 5);
		SelfDivisor.print1d(r2);
		int[] r3 = SelfDivisor.firstNumSelfDivisors(500, 10);
		SelfDivisor.print1d(r3);
	}
}

class SelfDivisor {
	/**
	 * @param number the number to be tested Precondition: number > 0
	 * @return true if every decimal digit of number is a divisor of number; false
	 *         otherwise
	 */
	// Answer for 2007 FRQ 1.(a)
	public static boolean isSelfDivisor(int number) {
		if (number <= 0)
			return false;
		int quotient = number;
		int remainder = 0;
		while(quotient > 0) {
			remainder = quotient % 10; // Strip-off right digit
			if(remainder==0)  // digit contains 0
				return false;
			if (number % remainder != 0) // Cannot be divided
				return false;
			quotient = quotient / 10; // Next quotient
		}
		return true;
	}

	/**
	 * @param start starting point for values to be checked Precondition: start > 0
	 * @param num   the size of the array to be returned Precondition: num > 0
	 * @return an array containing the first num integers ≥ start that are
	 *         self-divisors
	 */
	// Answer for 2007 FRQ 1.(b)
	public static int[] firstNumSelfDivisors(int start, int num) { /* to be implemented in part (b) */
		int[] data = new int[num];
		int counter = 0;
		while(counter < num) {
			if (isSelfDivisor(start)) {
				data[counter] = start;
				counter++;
			}
			start++;
		}
		return data;
	}
	
	public static void print1d(int[] data) {
		for(int element: data)
			System.out.print(element + "; ");
		System.out.println();
	}
}
