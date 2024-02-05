package APCSA.FRQ._2017;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2017Q3 {
	public static void main(String[] args) {
		// Test for 2017 FRQ 3.(b)
		Phrase p1 = new Phrase("This That This This This Yes Let us do it");
		System.out.println(p1.findNthOccurrence("This", 3)); 
		Phrase p2 = new Phrase("Today we are going to withdraw from Afganistan.");
		System.out.println(p2.findNthOccurrence("going", 3)); 
		Phrase p3 = new Phrase("We Us You Him We We");
		System.out.println(p3.findNthOccurrence("We", 5)); 
		
		// Test for 2017 FRQ 3.(a)
		Phrase phrase1 = new Phrase("A cat ate late.");
		phrase1.replaceNthOccurrence("at", 1, "rane");
		System.out.println(phrase1); // A crane ate late.
		Phrase phrase2 = new Phrase("A cat ate late.");
		phrase2.replaceNthOccurrence("at", 6, "xx");
		System.out.println(phrase2); // A cat ate late.
		Phrase phrase3 = new Phrase("A cat ate late.");
		phrase3.replaceNthOccurrence("bat", 2, "xx");
		System.out.println(phrase3); // A cat ate late.
		Phrase phrase4 = new Phrase("aaaa");
		phrase4.replaceNthOccurrence("aa", 1, "xx");
		System.out.println(phrase4); // xxaa
		Phrase phrase5 = new Phrase("aaaa");
		phrase5.replaceNthOccurrence("aa", 2, "bbb");
		System.out.println(phrase5); // abbba
	}
}

class Phrase {
	private String currentPhrase;

	/** Constructs a new Phrase object. */
	public Phrase(String p) {
		this.currentPhrase = p;
	}

	/**
	 * Returns the index of the nth occurrence of str in the current phrase; returns
	 * -1 if the nth occurrence does not exist. 
	 * Precondition: str.length() > 0 and n > 0 
	 * Postcondition: the current phrase is not modified.
	 */
	public int findNthOccurrence(String str, int n) {
		final int NotFound = -1;
		int indexFound = NotFound;
		
		int index=0; // Next string position to seek
		int count=0; // Times of founds. Will compare with n.
		while (index <  this.currentPhrase.length()) { // Loop until end of phrase
			indexFound = this.currentPhrase.indexOf(str, index);
			if (indexFound == NotFound || count >= n) {
				break;
			}
			count++;
			index = indexFound+1; // Move to next index
		}
		
		if (count <= 0) { // Never found
			return -1;
		} else if (count < n) { // Found within less than n times
			return -1;
		} else { // Found equal to and more than n times
			return index; // Last found index
		}
	}
	/**
	 * Modifies the current phrase by replacing the nth occurrence of str with repl.
	 * If the nth occurrence does not exist, the current phrase is unchanged.
	 * Precondition: str.length() > 0 and n > 0
	 */
	// Answer for 2017 FRQ 3.(a)
	public void replaceNthOccurrence(String str, int n, String repl) {
		int loc = findNthOccurrence(str, n);
		if (loc != -1) {
			this.currentPhrase = this.currentPhrase.substring(0, loc-1) + repl + this.currentPhrase.substring(loc-1 + str.length());
		}
	}

	/**
	 * Returns the index of the last occurrence of str in the current phrase;
	 * returns -1 if str is not found. Precondition: str.length() > 0 Postcondition:
	 * the current phrase is not modified.
	 */
	// Answer for 2017 FRQ 3.(b)
	public int findLastOccurrence(String str) {
		int n = 1;
		while (findNthOccurrence(str, n + 1) != -1) {
			n++;
		}
		return findNthOccurrence(str, n);
	}

	/** Returns a string containing the current phrase. */
	public String toString() {
		return this.currentPhrase;
	}
}