package APCSA.FRQ._2016;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2016Q1 {
	public static void main(String[] args) {
		// Test for 2016 FRQ 1.(a)
		String[] wordArray = {"wheels", "on", "the", "bus"};
		
		RandomStringChooser strChooser = new RandomStringChooser(wordArray);
		for (int k = 0; k < 6; k++) {
			System.out.println(strChooser.getNext());
		}
		System.out.println("*********************");
		
		// Test for 2016 FRQ 1.(b)
		RandomLetterChooser letterChooser = new RandomLetterChooser("cat");
		for (int k = 0; k < 4; k++)
		{
			System.out.println(letterChooser.getNext());
		}
		System.out.println("*********************");
	}
}

// Answer for 2016 FRQ 1.(a)
class RandomStringChooser {
	private ArrayList<String> words = new ArrayList<String>();
	// Construct
	public RandomStringChooser(String[] wordArray) {
		words = new ArrayList<String>();
		for (String singleWord : wordArray) {
			words.add(singleWord);
		}
	}

	public String getNext() {
		if (words.size() > 0) {
			return words.remove((int) (Math.random() * words.size()));
		}
		return "NONE";
	}
}

class RandomLetterChooser extends RandomStringChooser {
	/**
	 * Constructs a random letter chooser using the given string str. Precondition:
	 * str contains only letters.
	 */
	// Answer for 2016 FRQ 1.(b)
	public RandomLetterChooser(String str) {
		super(getSingleLetters(str));
	}

	/**
	 * Returns an array of single-letter strings. Each of these strings consists of
	 * a single letter from str. Element k of the returned array contains the single
	 * letter at position k of str. For example, getSingleLetters("cat") returns the
	 * array { "c", "a", "t" }.
	 */
	public static String[] getSingleLetters(String str) {
		String[] letterArray = new String[str.length()];
		for (int i=0; i<str.length(); i++) {
			letterArray[i] = str.substring(i, i+1);
		}
		return letterArray;
	}
}

