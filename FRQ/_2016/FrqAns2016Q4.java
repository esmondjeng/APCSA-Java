package APCSA.FRQ._2016;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.List;

public class FrqAns2016Q4 {
	public static void main(String[] args) {
		List<String> myWords1 = new ArrayList<String>();
		myWords1.add("A");
		myWords1.add("frog");
		myWords1.add("is");
		// Test for 2016 FRQ 4.(a)
		System.out.println(myWords1);
		System.out.println("Ans should be 7 and print out " + StringFormatter.totalLetters(myWords1));

		List<String> myWords2 = new ArrayList<String>();
		myWords2.add("Hi");
		myWords2.add("Bye");
		// Test for 2016 FRQ 4.(a)
		System.out.println(myWords2);
		System.out.println("Ans Should be 5 and print out " + StringFormatter.totalLetters(myWords2));
		System.out.println("*********************");

		List<String> words1 = new ArrayList<String>();
		words1.add("AP");
		words1.add("COMP");
		words1.add("SCI");
		words1.add("ROCKS");
		// Test for 2016 FRQ 4.(b)
		System.out.println(words1);
		System.out.println("Gap should be 2 and print out (20) " + StringFormatter.basicGapWidth(words1, 20));
		System.out.println("Leftspaces (20) " + StringFormatter.leftoverSpaces(words1, 20));
		System.out.printf("20=%d + Gaps*%d +Leftover\n", StringFormatter.totalLetters(words1), words1.size()-1);
		System.out.println("*********************");
		
		List<String> words2 = new ArrayList<String>();
		words2.add("GREEN");
		words2.add("EGGS");
		words2.add("AND");
		words2.add("HAM");
		// Test for 2016 FRQ 4.(b)
		System.out.println(words2);
		System.out.println("Gap should be 1 and print out  (20) " + StringFormatter.basicGapWidth(words2, 20));
		System.out.println("Leftspaces (20) " + StringFormatter.leftoverSpaces(words2, 20));
		System.out.printf("20=%d + Gaps*%d +Leftover\n", StringFormatter.totalLetters(words2), words2.size()-1);
		System.out.println("*********************");
		
		List<String> words3 = new ArrayList<String>();
		words3.add("BEACH");
		words3.add("BALL");
		// Test for 2016 FRQ 4.(b)
		System.out.println(words3);
		System.out.println("Gap should be 11 and print out (20) " + StringFormatter.basicGapWidth(words3, 20));
		System.out.println("Leftspaces (20) " + StringFormatter.leftoverSpaces(words3, 20));
		System.out.printf("20=%d + Gaps*%d +Leftover\n", StringFormatter.totalLetters(words3), words3.size()-1);
	}
}

class StringFormatter {
	/**
	 * Returns the total number of letters in the words in its parameter wordList
	 */
	// Answer for 2016 FRQ 4.(a)
	public static int totalLetters(List<String> myWords) {
		int count = 0;
		for (String str : myWords) {
			count = count + str.length();
		}
		return count;
	}

	/**
	 * Returns the basic gap width when wordList is used to produce a formatted
	 * string of formattedLen characters. Precondition: wordList contains at least
	 * two words, consisting of letters only. formattedLen is large enough for all
	 * the words and gaps.
	 */
	// Answer for 2016 FRQ 4.(b)
	public static int basicGapWidth(List<String> wordList, int formattedLen) {
		int wordCount = wordList.size();
		int gap = (formattedLen - totalLetters(wordList)) / (wordCount-1);
		return gap;
	}
	// Support for 2016 FRQ 4.(c) Answer
	public static int leftoverSpaces(List<String> wordList, int formattedLen) {
		int wordCount = wordList.size();
		int spaces = formattedLen - (wordCount-1)*basicGapWidth(wordList, formattedLen) - totalLetters(wordList);
		return spaces;
	}
	
	// Answer for 2016 FRQ 4.(c)
	public static String format(List<String> wordList, int formattedLen) {
		String formatted = "";
		int gapWidth = basicGapWidth(wordList, formattedLen);
		int leftovers = leftoverSpaces(wordList, formattedLen);
		for (int w = 0; w < wordList.size() - 1; w++) {
			formatted = formatted + wordList.get(w);
			for (int i = 0; i < gapWidth; i++) {
				formatted = formatted + " ";
			}
			if (leftovers > 0) {
				formatted = formatted + " ";
				leftovers--;
			}
		}
		formatted = formatted + wordList.get(wordList.size() - 1);
		return formatted;
	}
}