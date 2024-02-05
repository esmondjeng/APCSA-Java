package APCSA.FRQ._2015;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2015Q2 {
	public static void main(String[] args) {
		// Test for 2015 FRQ 2
		HiddenWord puzzle = new HiddenWord("HARPS");
		System.out.println(puzzle.getHint("AAAAA"));
		System.out.println(puzzle.getHint("HELLO"));
		System.out.println(puzzle.getHint("HEART"));
		System.out.println(puzzle.getHint("HARMS"));
		System.out.println(puzzle.getHint("HARPS"));
	}
}

// Answer for 2015 FRQ 2
class HiddenWord {
	private String word;

	public HiddenWord(String hWord) {
		word = hWord;
	}

	public String getHint(String guess) {
		String hint = "";
		for (int i = 0; i < guess.length(); i++) {
			if (guess.substring(i, i + 1).equals(word.substring(i, i + 1))) {
				hint += guess.substring(i, i + 1);
			} else if (word.indexOf(guess.substring(i, i + 1)) != -1) {
				hint += "+";
			} else {
				hint += "*";
			}
		}
		return hint;
	}
}