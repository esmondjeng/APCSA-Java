package APCSA.FRQ._2018;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2018Q3 {
	public static void main(String[] args) {
		// Test for 2018 FRQ 3
		StringChecker sc1 = new CodeWordChecker(5, 8, "$");
		System.out.println(sc1.isValid("happy"));	// true
		System.out.println(sc1.isValid("happy$"));	// false
		System.out.println(sc1.isValid("Code"));	// false
		System.out.println(sc1.isValid("HappyCode"));// false
		
		// Test for 2018 FRQ 3
		StringChecker sc2 = new CodeWordChecker("pass");
		System.out.println(sc2.isValid("MyPass"));	// true
		System.out.println(sc2.isValid("Mypassport"));	// false
		System.out.println(sc2.isValid("happy"));	// false
		System.out.println(sc2.isValid("1,000,000,000,000,000"));// false
	}
}

interface StringChecker {
	/** Returns true if str is valid. */
	boolean isValid(String str);
}

// Answer for 2018 FRQ 3
class CodeWordChecker implements StringChecker {
	private int minCodeWordLength;
	private int maxCodeWordLength;
	private String wordNotAllowed;
	// Construct
	public CodeWordChecker(int min, int max, String str) {
		this.minCodeWordLength = min;
		this.maxCodeWordLength = max;
		this.wordNotAllowed = str;
	}
	// Overloaded Construct
	public CodeWordChecker(String str) {
		this.minCodeWordLength = 6;
		this.maxCodeWordLength = 20;
		this.wordNotAllowed = str;
	}
	// Assessor Method
	public boolean isValid(String str) {
		int notFound = -1;
		
		if (str.length() < minCodeWordLength || str.length() > maxCodeWordLength) {
			return false;
		}
		
		if (str.indexOf(this.wordNotAllowed)==notFound) {
			return true;
		} else {
			return false;
		}
	}
}