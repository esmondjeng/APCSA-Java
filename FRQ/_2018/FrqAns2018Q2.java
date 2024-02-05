package APCSA.FRQ._2018;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2018Q2 {
	public static void main(String[] args) {
		String[] baseStr1 = { "ABC", "DEF", "GHJ", "JKL", "MNO", "PQR" };
		// Test for 2018 FRQ 2.(a)
		WordPairList wordPairSequence1 = new WordPairList(baseStr1);
		System.out.println(wordPairSequence1.allPairs.size()); // C(6,2)=15
		wordPairSequence1.display();
		// Test for 2018 FRQ 2.(b)
		System.out.println(wordPairSequence1.numMatches());
		
		String[] baseStr2 = { "111", "222", "111", "111", "333" };
		// Test for 2018 FRQ 2.(a)
		WordPairList wordPairSequence2 = new WordPairList(baseStr2);
		System.out.println(wordPairSequence2.allPairs.size()); // C(5,2)=10
		wordPairSequence2.display();
		// Test for 2018 FRQ 2.(b)
		System.out.println(wordPairSequence2.numMatches());
	}
}

class WordPair {
	private String first;
	private String second;
	
	/** Constructs a WordPair object. */
	public WordPair(String first, String second) {
		/* implementation not shown */
		this.first = first;
		this.second = second;
	}

	/** Returns the first string of this WordPair object. */
	public String getFirst() {
		return this.first;
	}

	/** Returns the second string of this WordPair object. */
	public String getSecond() {
		return this.second;
	}
} // End of WordPair class

class WordPairList {
	/** The list of word pairs, initialized by the constructor. */
	ArrayList<WordPair> allPairs;

	/**
	 * Constructs a WordPairList object as described in part (a). Precondition:
	 * words.length >= 2
	 */
	// Answer for 2018 FRQ 2.(a)
	public WordPairList(String[] words) {
		allPairs = new ArrayList<WordPair>();
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				allPairs.add(new WordPair(words[i], words[j]));
			}
		}
	} // End of construct WordPairList()

	/**
	 * Returns the number of matches as described in part (b).
	 */
	// Answer for 2018 FRQ 2.(b)
	public int numMatches() {
		int count = 0;
		for (WordPair pair : allPairs) {
			if (pair.getFirst().equals(pair.getSecond())) {
				count++;
			}
		}
		return count;
	} // End of numMatches()
	
	public void display() {
		for (WordPair pair : allPairs) {
			System.out.print(pair.getFirst());
			System.out.println("\t"+pair.getSecond());
		}
	} // End of display()
} // End of WordPairList class