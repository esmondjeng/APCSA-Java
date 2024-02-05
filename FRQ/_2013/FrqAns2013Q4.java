package APCSA.FRQ._2013;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2013Q4 {
	public static void main(String[] args) {
		// Test for 2013 FRQ 4.(a)
		double[] d1 = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9};
		SkyView nightSky = new SkyView(4, 3, d1);
		double[] d2 = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1};
		SkyView nightSky2 = new SkyView(3, 2, d2);
		System.out.println(nightSky);
		System.out.println(nightSky2);
		
		// Test for 2013 FRQ 4.(b)
		double sum = nightSky.getAverage(1, 2, 0, 1);
		System.out.println(sum);
	}
}

class SkyView {
	/**
	 * A rectangular array that holds the data representing a rectangular area of
	 * the sky.
	 */
	private double[][] view;

	/**
	 * Constructs a SkyView object from a 1-dimensional array of scan data.
	 * 
	 * @param numRows the number of rows represented in the view Precondition:
	 *                numRows > 0
	 * @param numCols the number of columns represented in the view Precondition:
	 *                numCols > 0
	 * @param scanned the scan data received from the telescope, stored in telescope
	 *                order
	 * Precondition: scanned.length == numRows * numCols
	 * Postcondition: view has been created as a rectangular
	 *                2-dimensional array with numRows rows and numCols columns and
	 *                the values in scanned have been copied to view and are ordered
	 *                as in the original rectangular area of sky.
	 */
	// Answer for 2013 FRQ 4.(a)
	public SkyView(int numRows, int numCols, double[] scanned) {
		this.view = new double[numRows][numCols];
		int index = 0;
		
		for (int i=0; i < view.length; i++) {
			if (i%2==0) {
				for (int j=0; j <= view[i].length-1; j++) {
					this.view[i][j] = scanned[index];
					index ++;
				}
			}
			if (i%2!=0) {
				for (int j=view[i].length-1; j >= 0 ; j--) {
					this.view[i][j] = scanned[index];
					index ++;
				}
			}
		}
	}

	/**
	 * Returns the average of the values in a rectangular section of view.
	 * 
	 * @param startRow the first row index of the section
	 * @param endRow   the last row index of the section
	 * @param startCol the first column index of the section
	 * @param endCol   the last column index of the section Precondition: 0 <=
	 *                 startRow <= endRow < view.length Precondition: 0 <= startCol
	 *                 <= endCol < view[0].length
	 * @return the average of the values in the specified section of view
	 */
	// Answer for 2013 FRQ 4.(b)
	public double getAverage(int startRow, int endRow, int startCol, int endCol) {
		double sum = 0;
		for (int i=startRow; i <= endRow; i++) {
			for (int j=startCol; j <= endCol; j++) {
				sum = sum + this.view[i][j] ;
			}
		}
		return sum;
	}
	
	@Override
	public String toString() {
		String str="";
		for(double[] dataRow: this.view) {
			for(double dataElement: dataRow) {
				str = str + dataElement + "\t";
			}
			str = str + "\n";
		}
		return str;
	}
}