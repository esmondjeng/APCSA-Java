package APCSA.FRQ._2019;
/**
 * https://runestone.academy/runestone/books/published/csjava/Unit8-ArrayList/2019delimitersQ3a.html
 * https://runestone.academy/runestone/books/published/csjava/Unit8-ArrayList/2019delimitersQ3b.html
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList; // 引入 ArrayList Class

public class FrqAns2019Q3 {
	public static void main(String[] args) {
		ArrayList<String> delList = new ArrayList<String>();
		
		// Try delimiter - ( , ) - with str1 token
		Delimiters d1 = new Delimiters("(", ")");
		String[] str1 = { "(", "x+y", ")", "*", "5" };
		delList = d1.getDelimtersList(str1);
		System.out.println("It should print TRUE and it prints " + d1.isBalanced(delList));
		
		// Try delimiter - <q>, </q> - with str2 token
		Delimiters d2 = new Delimiters("<q>", "</q>");
		String[] str2 = { "<q>", "yy", "</q>", "zz", "</q>" };
		delList = d2.getDelimtersList(str2);
		System.out.println("It should print FALSE and it prints " + d2.isBalanced(delList));
		
		// Try delimiter - <sup>, </sup> - with 1st tokens
		// Test for 2019 FRQ 3.(a) & FRQ 3.(b)
		Delimiters del = new Delimiters("<sup>", "</sup>");
		String[] tokens1 = { "<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>" };
		delList = del.getDelimtersList(tokens1);
		System.out.println("It should print TRUE and it prints " + del.isBalanced(delList));
		// Try delimiter - <sup>, </sup> - with 2nd tokens
		// Test for 2019 FRQ 3.(a) & FRQ 3.(b)
		String[] tokens2 = { "<sup>", "</sup>", "</sup>", "<sup>" };
		delList = del.getDelimtersList(tokens2);
		System.out.println("It should print TRUE and it prints " + del.isBalanced(delList));
		// Try delimiter - <sup>, </sup> - with 3rd tokens
		// Test for 2019 FRQ 3.(a) & FRQ 3.(b)
		String[] tokens3 = { "<sup>", "</sup>", "</sup>" };
		delList = del.getDelimtersList(tokens3);
		System.out.println("It should print FALSE and it prints " + del.isBalanced(delList));
		// Try delimiter - <sup>, </sup> - with 4th tokens
		// Test for 2019 FRQ 3.(a) & FRQ 3.(b)
		String[] tokens4 = { "</sup>" };
		delList = del.getDelimtersList(tokens4);
		System.out.println("It should print FALSE and it prints " + del.isBalanced(delList));
		// Try delimiter - <sup>, </sup> - with 5th tokens
		// Test for 2019 FRQ 3.(a) & FRQ 3.(b)
		String[] tokens5 = { "</sup>", "</sup>", "<sup>" };
		delList = del.getDelimtersList(tokens5);
		System.out.println("It should print FALSE and it prints " + del.isBalanced(delList));
	}
}

class Delimiters {
	/** The open and close delimiters **/
	private String openDel;
	private String closeDel;

	/**
	 * Constructs a Delimiters object were open is the open delimiter and close is
	 * the close delimiter. Precondition: open and close are non-empty strings
	 */
	public Delimiters(String open, String close) {
		openDel = open;
		closeDel = close;
	}

	// Answer for 2019 FRQ 3.(a)
	/**
	 * Returns an ArrayList of delimiters from the array tokens, as described in part (a).
	 */
	public ArrayList<String> getDelimtersList(String[] tokens) {
		ArrayList<String> delList = new ArrayList<String>(); // Declare an empty ArrayList

		for (String element : tokens) {
			// If tokens element meet openDel OR closeDel, add element into ArrayList
			if (element.equals(this.openDel) || element.equals(this.closeDel)) {
				delList.add(element);
			}
		}
		return delList;
	}

	// Answer for 2019 FRQ 3.(b)
	/**
	 * Returns true if the delimiters are balanced and false otherwise, as described in part (b).
	 * Precondition: delimiters contains only valid open and close
	 * delimiters.
	 */
	public boolean isBalanced(ArrayList<String> delimiters) {
		int countLeft = 0;
		int countRight = 0;
				
		for (String element : delimiters) {
			// If tokens element meet openDel OR closeDel, add element into ArrayList
			if (element.equals(this.openDel)) {
				countLeft++;
			} else if (element.equals(this.closeDel)) {
				countRight++;
			} else {
				// Do nothing when neither delimiters accidentally.
			}
		}
		if (countLeft == countRight)
			return true;
		else
			return false;
	}
}

/*
 * It should print TRUE and it prints true
 * It should print FALSE and it prints false
 * It should print TRUE and it prints true
 * It should print TRUE and it prints true
 * It should print FALSE and it prints false
 * It should print FALSE and it prints false
 * It should print FALSE and it prints false
 */
