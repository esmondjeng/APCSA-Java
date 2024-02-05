package APCSA.FRQ._2011;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2011Q4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Meet at noon";
		String str2 = "Meet at midnight";
		RouteCipher rc = new RouteCipher(5, 3);

		// Test for 2011 FRQ 4.(a)
		rc.fillBlock(str1);
		rc.display();
		rc.fillBlock(str2);
		rc.display();
		System.out.println("***************");

		// Test for 2011 FRQ 4.(b)
		System.out.println(rc.encryptMessage("Meet a"));
	}
}

class RouteCipher {
	/**
	 * A two-dimensional array of single-character strings, instantiated in the
	 * constructor
	 */
	private String[][] letterBlock;
	/** The number of rows of letterBlock, set by the constructor */
	private int numRows;
	/** The number of columns of letterBlock, set by the constructor */
	private int numCols;

	public RouteCipher(int r, int c) {
		this.numRows = c;
		this.numCols = r;
		letterBlock = new String[this.numRows][this.numCols];
		for (int i = 0; i < this.letterBlock.length; i++) {
			for (int j = 0; j < this.letterBlock[i].length; j++) {
				this.letterBlock[i][j] = "";
			}
		}
	}

	/**
	 * Places a string into letterBlock in row-major order.
	 * 
	 * @param str the string to be processed Postcondition: if str.length() <
	 *            numRows * numCols, "A" is placed in each unfilled cell if
	 *            str.length() > numRows * numCols, trailing characters are ignored
	 */
	// Option 1 Answer for 2011 FRQ 4.(a)
	public void fillBlock(String str) {
		int counter = 0; // counter to index inputed String
		for (int i = 0; i < this.letterBlock.length; i++) {
			for (int j = 0; j < this.letterBlock[i].length; j++) {
				if (counter < str.length()) {
					this.letterBlock[i][j] = str.substring(counter, counter + 1);
					counter++;
				} else {
					this.letterBlock[i][j] = "A";
				}
			}
		}
	}

	// Option 2 Answer for 2011 FRQ 4.(a)
	private void fillBlock2(String str) {
		for (int r = 0; r < this.numRows; r++) {
			for (int c = 0; c < this.numCols; c++) {
				if (str.length() > (c + (r * this.numCols))) {
					this.letterBlock[r][c] = str.substring(c + r * this.numCols, 1 + c + r * this.numCols);
				} else {
					this.letterBlock[r][c] = "A";
				}
			}
		}
	}

	/**
	 * Extracts encrypted string from letterBlock in column-major order.
	 * Precondition: letterBlock has been filled
	 * 
	 * @return the encrypted string from letterBlock
	 */
	public String encryptBlock() {
		/* implementation not shown */
		for (int j = 0; j < this.letterBlock[0].length; j++) {
			for (int i = 0; i < this.letterBlock.length; i++) {

			}
		}
		return "";
	}

	/**
	 * Encrypts a message.
	 * 
	 * @param message the string to be encrypted
	 * @return the encrypted message; if message is the empty string, returns the
	 *         empty string
	 */
	// Option 1 Answer for 2011 FRQ 4.(b)
	public String encryptMessage(String message) {
		String encryptedMessage = "";
		int chunkSize = this.numRows * this.numCols;
		while (message.length() > 0) {
			if (chunkSize > message.length()) {
				chunkSize = message.length();
			}
			fillBlock(message);
			encryptedMessage += encryptBlock();
			message = message.substring(chunkSize);
		}
		return encryptedMessage;
	}

	// Option 2 Answer for 2011 FRQ 4.(b)
	public String encryptMessage2(String message) {
		if (message.length() == 0)
			return "";
		fillBlock(message);
		if (message.length() <= this.numRows * this.numCols) {
			return encryptBlock();
		}
		return (encryptBlock() + encryptMessage2(message.substring(this.numRows * this.numCols)));
	}

	public void display() {
		for (int i = 0; i < this.letterBlock.length; i++) {
			for (int j = 0; j < this.letterBlock[i].length; j++) {
				System.out.print("\"" + this.letterBlock[i][j] + "\" ");
			}
			System.out.println();
		}
	}
}