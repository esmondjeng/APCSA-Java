package APCSA.FRQ._2017;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2017Q4 {
	public static void main(String[] args) {
		int[][] data = {{15, 5, 9, 10},
						{12, 16, 11, 6},
						{14, 8, 13, 7}};
		int[][] rand = gen2D(4, 5, 6); // (row, col, initial)
		print2D(data); System.out.println("**********");
		print2D(rand); System.out.println("**********");
		
		// Test for 2017 FRQ 4.(a)
		int x = 11;
		System.out.printf("Locate value %d at DATA position %s.\n", x, Position.findPosition(x, data));
		System.out.printf("Locate value %d at RAND position %s.\n", x, Position.findPosition(x, rand));
		System.out.println("**********");
		
		// Test for 2017 FRQ 4.(b)
		Position[][] pData = new Position[data.length][data[0].length];
		Position[][] pRand = new Position[rand.length][rand[0].length];
		pData = Position.getSuccessorArray(data);
		pRand = Position.getSuccessorArray(rand);
		for(Position[] dataRow: pData) {
			for(Position element: dataRow) {
				System.out.printf("%8s, ", element);
			}
			System.out.println();
		}
		System.out.println("**********");
		for(Position[] dataRow: pRand) {
			for(Position element: dataRow) {
				System.out.printf("%8s, ", element);
			}
			System.out.println();
		}
		
	}
	
	public static int[][] gen2D(int row, int col, int initial) {
		int[][] data = new int[row][col];
		ArrayList<Integer> input = genSeqList(initial, row*col);
		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				data[i][j] = pickOne(input);
			}
		}
		return data;
	}
	
	public static void print2D(int[][] data) {
		for(int i=0; i < data.length; i++) {
			for(int j=0; j < data[i].length; j++) {
				System.out.print(data[i][j] + ", ");
			}
			System.out.println();
		}
		return;
	}
	
	public static ArrayList<Integer> genSeqList(int initial, int length) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int i=0; i < length; i++) {
			data.add(i+initial);
		}
		return data;
	}
	
	public static int pickOne(ArrayList<Integer> data) {
		if (data.size() <= 0)
			return Integer.MIN_VALUE;
		int index = (int) (Math.random()*data.size());
		int temp = data.get(index);
		data.remove(index);
		return temp;
	}
}

class Position {
	int row;
	int col;
	/** Constructs a Position object with row r and column c. */
	public Position(int r, int c) {
		this.row = r;
		this.col = c;
	}

	/**
	 * Returns the position of num in intArr; returns null if no such element exists
	 * in intArr.
	 * Precondition: intArr contains at least one row.
	 */
	// Answer for 2017 FRQ 4.(a)
	public static Position findPosition(int num, int[][] intArr) {
		for (int i = 0; i < intArr.length; i++) {
			for (int j = 0; j < intArr[0].length; j++) {
				if (intArr[i][j] == num) { // Find one element == num
					return new Position(i, j); // return with position coordinate
				}
			}
		}
		return null;
	}

	/**
	 * Returns a 2D successor array as described in part (b) 
	 * constructed from intArr.
	 * Precondition: intArr contains at least one row and contains
	 * consecutive values. Each of these integers may be in any 
	 * position in the 2D array.
	 */
	// Answer for 2017 FRQ 4.(b)
	public static Position[][] getSuccessorArray(int[][] intArr) {
		Position[][] newArr = new Position[intArr.length][intArr[0].length];
		for (int i = 0; i < intArr.length; i++) {
			for (int j = 0; j < intArr[0].length; j++) {
				newArr[i][j] = findPosition(intArr[i][j] + 1, intArr);
			}
		}
		return newArr;
	}
	
	public String toString() {
		return String.format("(%d, %d)", this.row, this.col);
	}
}