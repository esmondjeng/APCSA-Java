package APCSA.FRQ._2014;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.List;

public class FrqAns2014Q1 {
	public static void main(String[] args) {
		// Test for 2014 FRQ 1.(a)
		System.out.println(scrambleWord("TAN"));
		System.out.println(scrambleWord("ABRACADABRA"));
		System.out.println(scrambleWord("WHOA"));
		System.out.println(scrambleWord("AARDVARK"));
		System.out.println(scrambleWord("APPLE"));
		System.out.println(scrambleWord("EGGS"));
		System.out.println(scrambleWord("A"));
		System.out.println(scrambleWord(""));
		
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("TAN");
		wordList.add("ABRACADABRA");
		wordList.add("WHOA");
		wordList.add("APPLE");
		wordList.add("EGGS");
		// Test for 2014 FRQ 1.(b)
		System.out.println(wordList);
		scrambleOrRemove(wordList);
		System.out.println(wordList);
		
		System.exit(0);
	} // End of main()

	// Answer for 2014 FRQ 1.(a)
	public static String scrambleWord(String word) {
		// No meaning to run while signle letter or no String content
		if (word.length() <= 1)
			return word;
		
		int current = 0;	// loop index for input String
		String result = "";	// Initialized return result/output String
		/*
		 * Loop while current position is within the String
		 */
		while (current <= word.length() - 2) {
			/*
			 * two consecutive letters consist of an "A" followed 
			 * by a letter that is not an "A",
			 */
			if (word.substring(current, current + 1).equals("A")
					&& !word.substring(current + 1, current + 2).equals("A")) {
				result += word.substring(current + 1, current + 2); // Swap
				result += "A";	// Swap
				current += 2;	// Move to next two position
			} else {
				result += word.substring(current, current + 1); //No change and just attach
				current++;		// Move to next position
			}
		} // While-loop to loop index String
		
		// Attach the last letter 
		if (current < word.length()) {
			result += word.substring(current);
		}
		return result;
	} // End of scrambleWord() Method

	// Answer for 2014 FRQ 1.(b)
	public static void scrambleOrRemove(List<String> wordList) {
		int index = 0;
		while (index < wordList.size()) {
			String word = wordList.get(index);		// Locate next String from List
			String scrambled = scrambleWord(word);	// Find scrambled result
			if (word.equals(scrambled)) {
				wordList.remove(index);				// Removed if no change
			} else {
				wordList.set(index, scrambled);		// Replaced if change
				index++;							// Move to next
			}
		}
	} // End of scrambleOrRemove() Method
} // End of // End of FrqAns2014Q1 class