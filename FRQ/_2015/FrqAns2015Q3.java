package APCSA.FRQ._2015;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.List;

public class FrqAns2015Q3 {
	public static void main(String[] args) {
		SparseArray sparse = new SparseArray();
		sparse.addSparseArrayEntry(1, 4, 4);
		sparse.addSparseArrayEntry(2, 0, 1);
		sparse.addSparseArrayEntry(3, 1, -9);
		sparse.addSparseArrayEntry(1, 1, 5);
		
		// Test for 2015 FRQ 3.(a)
		System.out.println(sparse.getValueAt(1,4)); // 4
		System.out.println(sparse.getValueAt(2,0)); // 1
		System.out.println(sparse.getValueAt(3,1)); // -9
		System.out.println(sparse.getValueAt(1,1)); // 5
		System.out.println(sparse.getValueAt(0,0)); // 0
		System.out.println(sparse.getValueAt(2,2)); // 0
		System.out.println(sparse.getValueAt(3,3)); // 0
		System.out.println(sparse.getValueAt(4,4)); // 0
		System.out.println("******************");
		
		// Test for 2015 FRQ 3.(b)
		sparse.removeColumn(1);
		System.out.println(sparse.getValueAt(3,1)); // 0
		System.out.println(sparse.getValueAt(1,1)); // 0
	}
}

class SparseArray {
	/** The number of rows and columns in the sparse array. */
	private int numRows;
	private int numCols;
	/**
	 * The list of entries representing the non-zero elements of the sparse array.
	 * Entries are stored in the list in no particular order. Each non-zero element
	 * is represented by exactly one entry in the list.
	 */
	private List<SparseArrayEntry> entries;
	
	/** Constructs an empty SparseArray. */
	public SparseArray() {
		entries = new ArrayList<SparseArrayEntry>();
	}
	/** Esmond add these code to add ArrayList elements */ 
	public void addSparseArrayEntry(int r, int c, int v) {
		entries.add(new SparseArrayEntry(r, c, v));
		this.numRows++;
		this.numCols++;
	}
	
	/** Returns the number of rows in the sparse array. */
	public int getNumRows() {
		return numRows;
	}

	/** Returns the number of columns in the sparse array. */
	public int getNumCols() {
		return numCols;
	}

	/**
	 * Returns the value of the element at row index row and column index col in the
	 * sparse array. 
	 * Precondition: 0 < row < getNumRows() 0 < col < getNumCols()
	 */
	// Answer for 2015 FRQ 3.(a)
	public int getValueAt(int row, int col) {
		for (SparseArrayEntry e : entries) {
			if (e.getRow() == row && e.getCol() == col) {
				return e.getValue();
			}
		}
		return 0;
	}

	/**
	 * Removes the column col from the sparse array. 
	 * Precondition: 0 < col < getNumCols()
	 */
	// Answer for 2015 FRQ 3.(b)
	public void removeColumn(int col) {
		int i = 0;
		while (i < entries.size()) {
			SparseArrayEntry e = entries.get(i);
			if (e.getCol() == col) {
				entries.remove(i);
			} else if (e.getCol() > col) {
				entries.set(i, new SparseArrayEntry(e.getRow(), e.getCol() - 1, e.getValue()));
				i++;
			} else {
				i++;
			}
		}
		numCols--;
	}
}

class SparseArrayEntry {
	/** The row index and column index for this entry in the sparse array */
	private int row;
	private int col;
	/** The value of this entry in the sparse array */
	private int value;

	/**
	 * Constructs a SparseArrayEntry object that represents a sparse array element
	 * with row index r and column index c, containing value v.
	 */
	public SparseArrayEntry(int r, int c, int v) {
		row = r;
		col = c;
		value = v;
	}

	/** Returns the row index of this sparse array element. */
	public int getRow() {
		return row;
	}

	/** Returns the column index of this sparse array element. */
	public int getCol() {
		return col;
	}

	/** Returns the value of this sparse array element. */
	public int getValue() {
		return value;
	}
}