package APCSA.FRQ._2008;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2008Q2 {
	public static void main(String[] args) {
		// Test for 2008 FRQ 2.(a) decode the original word with codes
		String master = "sixtyzipperswerequicklypickedfromthewovenjutebag";
		StringCoder a = new StringCoder(master);
		ArrayList<StringPart> sp = new ArrayList<StringPart>();
		sp.add(new StringPart(37, 3));
		sp.add(new StringPart(14, 2));
		sp.add(new StringPart(46, 2));
		sp.add(new StringPart(9, 2));
		System.out.println(sp);
		System.out.println(a.decodeString(sp));
		System.out.println("**********");

		// Test for findPart() Method - "overeager"
		ArrayList<StringPart> sp2 = new ArrayList<StringPart>();
		System.out.println(a.findPart("gg"));
		sp2.add(a.findPart("ove"));
		sp2.add(a.findPart("re"));
		sp2.add(a.findPart("ag"));
		sp2.add(a.findPart("er"));
		System.out.println(sp2);
		System.out.println("**********");

		// Test for 2008 FRQ 2.(b) to encode by inputed word
		// ArrayList<StringPart> sp3 = a.encodeString("overeager");
		ArrayList<StringPart> sp3 = a.encodeString2("overeager");
		// ArrayList<StringPart> sp3 = a.encodeString3("overeager");
		// ArrayList<StringPart> sp3 = a.encodeString4("overeager");
		System.out.println(sp3);
		System.out.println(a.decodeString(sp3));
	}
}

class StringPart {
	private int start;
	private int length;

	/**
	 * @param start  the starting position of the substring in a master string
	 * @param length the length of the substring in a master string
	 */
	public StringPart(int start, int length) {
		this.start = start;
		this.length = length;
	}

	/**
	 * @return the starting position of the substring in a master string
	 */
	public int getStart() { /* implementation not shown */
		return this.start;
	}

	/**
	 * @return the length of the substring in a master string
	 */
	public int getLength() { /* implementation not shown */
		return this.length;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", this.start, this.length);
	}
} // End of StringPart class

class StringCoder {
	private String masterString;

	/**
	 * @param master the master string for the StringCoder
	 * Precondition: the master string contains all the
	 * letters of the alphabet
	 */
	public StringCoder(String master) {
		masterString = master;
	}

	/**
	 * @param parts an ArrayList of string parts that are valid in the master string
	 * Precondition: parts.size() > 0
	 * @return the string obtained by concatenating the parts of the master string
	 */
	// Answer for 2008 FRQ 2.(a)
	public String decodeString(ArrayList<StringPart> parts) {
		String str = "";
		for (StringPart element : parts) {
			int start = element.getStart();
			int end = start + element.getLength();
			str = str + this.masterString.substring(start, end);
		}

		return str;
	}

	/**
	 * @param str the string to encode using the master string
	 * Precondition: all of the characters in str appear in the master string;
	 * str.length() > 0
	 * @return a string part in the master string that matches the beginning of str.
	 * The returned string part has length at least 1.
	 */
	public StringPart findPart(String str) {
		if (str == null || str.length() == 0)
			return null;
		int start = masterString.indexOf(str);// !=-1, then first found
		int length = str.length();
		StringPart sp = new StringPart(start, length);

		return (start == -1 ? null : sp);
	}

	/**
	 * @param word the string to be encoded Precondition: all of the characters
	 * in word appear in the master string; word.length() > 0
	 * @return an ArrayList of string parts of the master string that can be
	 * combined to create word
	 */
	// Standard Answer for 2008 FRQ 2.(b)
	public ArrayList<StringPart> encodeString(String word) {
		ArrayList<StringPart> parts = new ArrayList<StringPart>();
		int index = 0;
		while (index < word.length()) {
			StringPart nextPart = findPart(word.substring(index));
			System.out.printf("%s (%d) %s\n", word, index, nextPart);
			parts.add(nextPart);
			index += nextPart.getLength();
		}
		return parts;
	}

	// Esmond's Answer(1) for 2008 FRQ 2.(b) looping backwards
	public ArrayList<StringPart> encodeString2(String word) {
		ArrayList<StringPart> parts = new ArrayList<StringPart>();
		String next = word;
		/*
		 * Loop on search next proper word by deducting previous found
		 */
		while (next.length() > 0) {
			// DEBUG: System.out.printf("Next Word: %s\n", next);
			String found = next;
			/*
			 * Loop on reduce proper word by one character backward if not found
			 */
			while (found.length() > 0) {
				StringPart nextPart = findPart(found);
				// DEBUG: System.out.printf("%s (%d) %s\n", found, found.length(), nextPart);
				if (nextPart != null) { // Found, add to the result ArrayList
					parts.add(nextPart);
					break;
				} else { // Not Found, reduce one character
					found = found.substring(0, found.length() - 1);
				}
			}

			/*
			 * Establish next word by deducting current found
			 */
			next = next.substring(found.length(), next.length());
		}
		return parts;
	}

	// Esmond's Answer(2) for 2008 FRQ 2.(b) looping backwards
	public ArrayList<StringPart> encodeString3(String word) {
		ArrayList<StringPart> parts = new ArrayList<StringPart>();
		int index = 0;
		/*
		 * Loop on search next proper word by deducting previous found
		 */
		while (index < word.length()) {
			String resultStr = "";
			StringPart nextPart = null;
			/*
			 * Loop on reduce proper word by one character backward if not found
			 */
			for (int j = index + 2; j <= word.length(); j++) {
				String tempStr = word.substring(index, j);
				StringPart r = this.findPart(tempStr);
				// DEBUG: System.out.printf("%s (%d, %d) %s\n", tempStr, index, j, r);
				if (r != null) {
					resultStr = tempStr;
					nextPart = r;
				}
			}

			/*
			 * Establish next word by deducting current found
			 */
			if (nextPart != null) { // Found Last
				parts.add(nextPart);
				index = index + resultStr.length(); // Move to next word index
			} else {
				index++; // Move to neighboring word index
			}
		}

		return parts;
	}

	// Esmond's Wrong Answer for 2008 FRQ 2.(b) looping firwards
	public ArrayList<StringPart> encodeString4(String word) {
		/* to be implemented in part (b) */
		ArrayList<StringPart> parts = new ArrayList<StringPart>();
		int index = 0;
		while (index < word.length()) {
			int foundLen = 1;
			int remainLen = word.length() - index;
			StringPart nextPart = null;
			// Loop while Not Found or no String length left to run
			while (nextPart == null && foundLen < remainLen) {
				foundLen++;
				String str = word.substring(index, index + foundLen);
				// DEBUG: System.out.printf("RemainLen:%d, FoundLen:%d, Goal:%s\n", remainLen,
				// foundLen, str);
				nextPart = this.findPart(str);

			}
			if (nextPart != null)
				parts.add(nextPart);
			index = index + foundLen; // Next word to find
		}

		return parts;
	}
} // End of StringCoder class