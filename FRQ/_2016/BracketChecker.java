package APCSA.FRQ._2016;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.Stack;

public class BracketChecker {
	private String input;

	// Construct
	public BracketChecker(String in) {
		input = in;
	}

	//
	public void check() {
		// Declare a char stack for push and pop
		// �ɶԳ���ʹ��Stack
		Stack<Character> theStack = new Stack<Character>();

		for (int j = 0; j < input.length(); j++) {
			// Loop to extract char from String one by one
			char ch = input.charAt(j);
			switch (ch) {
				case '{': // Left
				case '[': // Left
				case '(': // Left
					theStack.push(ch);
					break;
				case '}': // Right
				case ']': // Right
				case ')': // Right
					if (!theStack.isEmpty()) { // Has Left
						char chx = theStack.pop(); // Pop up previous Left
						if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '('))
							System.out.println("Error: " + ch + " at " + j);
					} else // Never has Left
						System.out.println("Error: " + ch + " at " + j);
					break;
				default:
					break;
			}
		}
		if (!theStack.isEmpty()) {
			System.out.println("Error: missing right delimiter");
		}
	}

	/**
	 * Main Program
	 * 
	 */
	public static void main(String[] args) {
		String input;
		input = "[()]ttt()()";

		BracketChecker theChecker = new BracketChecker(input);
		theChecker.check();
	}
}
