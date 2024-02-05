package APCSA.FRQ._2021;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2021Q1 {
	public static void main(String[] args) {
		// Test for 2021 FRQ 1.(a)
		WordMatch game1 = new WordMatch("mississippi");
		System.out.println(game1.scoreGuess("i"));
		System.out.println(game1.scoreGuess("iss"));
		System.out.println(game1.scoreGuess("issipp"));
		System.out.println(game1.scoreGuess("mississippi"));
		System.out.println("**********");
		
		// Test for 2021 FRQ 1.(a)
		WordMatch game2 = new WordMatch("aaaabb");
		System.out.println(game2.scoreGuess("a"));
		System.out.println(game2.scoreGuess("aa"));
		System.out.println(game2.scoreGuess("aaa"));
		System.out.println(game2.scoreGuess("aabb"));
		System.out.println(game2.scoreGuess("c"));
		System.out.println("**********");
		
		// Test for 2021 FRQ 1.(b)
		WordMatch game3 = new WordMatch("concatenation");
		System.out.println(game3.scoreGuess("ten"));
		System.out.println(game3.scoreGuess("nation"));
		System.out.println(game3.findBetterGuess("ten" , "nation"));
		System.out.println(game3.scoreGuess("con"));
		System.out.println(game3.scoreGuess("cat"));
		System.out.println(game3.findBetterGuess("con", "cat"));
	}
}

class WordMatch {
	/** The secret string. */
	private String secret;

	/**
	 * Constructs a WordMatch object with the given secret string of lowercase
	 * letters.
	 */
	public WordMatch(String word) {
		this.secret = word;
	}

	/**
	 * Returns a score for guess, as described in part (a). Precondition: 0 <
	 * guess.length() <= secret.length()
	 */
	// Answer for 2021 FRQ 1.(a)
	public int scoreGuess(String guess) {
		String searchStr = this.secret; // Keep no change on property variable
		int foundIndex = searchStr.indexOf(guess);
		int counter = 0;
		while (foundIndex!=-1) {
			counter++;
			searchStr = searchStr.substring(foundIndex+1);
			// DEBUG: System.out.printf("Counter:%d, Next Seach:%s\n", counter, searchStr);
			foundIndex = searchStr.indexOf(guess);
		}
			
		return guess.length()*guess.length()*counter;
	}
	// Optional Answer for 2021 FRQ 1.(a)
	public int scoreGuess2(String guess) {
		int counter = 0;
		for (int i=0; i < this.secret.length()-guess.length(); i++) {
			if(this.secret.substring(i, i+guess.length()).equals(guess)) {
				// DEBUG: System.out.println(this.secret.substring(i, i+guess.length()));
				counter++;
			}
		}
		return guess.length()*guess.length()*counter;
	}

	/**
	 * Returns the better of two guesses, as determined by scoreGuess and the rules
	 * for a tie-breaker that are described in part (b).
	 * Precondition: guess1 and guess2 contain all lowercase letters.
	 * guess1 is not the same as guess2.
	 */
	// Answer for 2021 FRQ 1.(b)
	public String findBetterGuess(String guess1, String guess2) {
		if(scoreGuess(guess1) > scoreGuess(guess2))
			return guess1;
		if(scoreGuess(guess2) > scoreGuess(guess1))
			return guess2;
		if(guess1.compareTo(guess2) > 0)
			return guess1;
		return guess2;
	}
}