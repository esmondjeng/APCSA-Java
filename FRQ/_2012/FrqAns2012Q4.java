package APCSA.FRQ._2012;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2012Q4 {
	public static void main(String[] args) {
		GrayImage a = new GrayImage(5, 6);
		a.display();
		// Test for 2012 FRQ 4.(a)
		System.out.println("White Counts: " + a.countWhitePixels());
		
		// Test for 2012 FRQ 4.(b)
		a.processImage();
		a.display();
	}
}

class GrayImage {
	public static final int BLACK = 0;
	public static final int WHITE = 255;
	/**
	 * The 2-dimensional representation of this image. Guaranteed not to be null.
	 * All values in the array are within the range [BLACK, WHITE], inclusive.
	 */
	private int[][] pixelValues;
	
	public GrayImage(int r, int c) {
		pixelValues = new int[r][c];
		for (int i=0; i < pixelValues.length; i++) {
			for (int j=0; j < pixelValues[i].length; j++) {
				pixelValues[i][j] = (int)(Math.random()*256);
			}
		}
		for (int i=0; i < (int)(r*c/10); i++) {
			pixelValues[(int)(Math.random()*r)][(int)(Math.random()*c)] = WHITE;
		}
		for (int i=0; i < (int)(r*c/10); i++) {
			pixelValues[(int)(Math.random()*r)][(int)(Math.random()*c)] = BLACK;
		}
	}

	/**
	 * @return the total number of white pixels in this image. Postcondition: this
	 *         image has not been changed.
	 */
	// Answer for 2012 FRQ 4.(a)
	public int countWhitePixels() {
		int count=0;
		for (int i=0; i < pixelValues.length; i++) {
			for (int j=0; j < pixelValues[i].length; j++) {
				if(pixelValues[i][j]==WHITE) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Processes this image in row-major order and decreases the value of each pixel
	 * at position (row, col) by the value of the pixel at position (row + 2, col + 2)
	 * if it exists. 
	 * Resulting values that would be less than BLACK are replaced by BLACK.
	 * Pixels for which there is no pixel at position (row + 2, col + 2) are unchanged.
	 */
	// Answer for 2012 FRQ 4.(b)
	public void processImage() {
		int r=0;
		int c=0;
		for (int i=0; i < pixelValues.length; i++) {
			for (int j=0; j < pixelValues[i].length; j++) {
				r = i + 2; c = j + 2;
				// If pixel at position (row + 2, col + 2) exists
				if(r < pixelValues.length && c < pixelValues[i].length) {
					int reduction = pixelValues[r][c];
					if ((pixelValues[i][j]-reduction)<BLACK)	// deduction to negative
						pixelValues[i][j]=BLACK;
					else 										// deduction > 0
						pixelValues[i][j]=pixelValues[i][j]-reduction;
				}
			}
		}
	}
		
	public void display() {
		for (int i=0; i < pixelValues.length; i++) {
			for (int j=0; j < pixelValues[i].length; j++) {
				System.out.printf("%3d " ,pixelValues[i][j]);
			}
			System.out.println();
		}
		System.out.println("**********");
	}
}