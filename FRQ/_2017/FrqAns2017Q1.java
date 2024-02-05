package APCSA.FRQ._2017;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2017Q1 {
	public static void main(String[] args) {
		// Test for 2017 FRQ 1.(a)
		Digits d1 = new Digits(15704);
		Digits d2 = new Digits(9);
		System.out.println(d1.digitList);
		System.out.println(d2.digitList);
		
		// Test for 2017 FRQ 1.(b)
		System.out.println(new Digits(7).isStrictlyIncreasing()); // true
		System.out.println(new Digits(1356).isStrictlyIncreasing()); // true
		System.out.println(new Digits(1336).isStrictlyIncreasing()); // false
		System.out.println(new Digits(1536).isStrictlyIncreasing()); // false
		System.out.println(new Digits(65310).isStrictlyIncreasing()); // false
	}
}

class Digits {
	ArrayList<Integer> digitList = new ArrayList<Integer>();
	// Answer for 2017 FRQ 1.(a)
	public Digits(int num) {
		
		if (num < 10) {
			this.digitList.add(num);
		} else {
			while (num > 0) {
				this.digitList.add(0, num % 10); // Remainder is the stripe-off
				num = num / 10; // Quotient as the next num
			}
		}
	}

	// Answer for 2017 FRQ 1.(b)
	public boolean isStrictlyIncreasing() {
		for (int i = 0; i < this.digitList.size() - 1; i++) {
			if (this.digitList.get(i).intValue() >= this.digitList.get(i + 1).intValue()) {
				return false;
			}
		}
		return true;
	}
}