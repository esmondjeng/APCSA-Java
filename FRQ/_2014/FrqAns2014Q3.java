package APCSA.FRQ._2014;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.List;

public class FrqAns2014Q3 {
	public static void main(String[] args) {
		ArrayList<Student> roster = new ArrayList<Student>();
		roster.add(new Student("Karen", 3));
		roster.add(new Student("Liz", 1));
		roster.add(new Student("Paul", 4));
		roster.add(new Student("Lester", 1));
		roster.add(new Student("Henry", 5));
		roster.add(new Student("Renee", 9));
		roster.add(new Student("Glen", 2));
		roster.add(new Student("Fran", 6));
		roster.add(new Student("David", 1));
		roster.add(new Student("Danny", 3));
		System.out.println(roster);
		// Test for 2014 FRQ 3.(a)
		SeatingChart introCS = new SeatingChart(roster, 3, 4);
		introCS.display();
		// Test for 2014 FRQ 3.(b)
		introCS.removeAbsentStudents(4);
		introCS.display();
	} // End of main()
} // End of FrqAns2014Q3 class

class Student {
	private String Name;
	private int absenceCount;

	/* Construct */
	public Student(String Name, int count) {
		this.Name = Name;
		this.absenceCount = count;
	}

	/* Returns the name of this Student. */
	public String getName() {
		return this.Name;
	}

	/* Returns the number of times this Student has missed class. */
	public int getAbsenceCount() {
		return this.absenceCount;
	}

	/**
	 * Output Method to display property content
	 */
	public void display() {
		System.out.printf("Name: %s (%d)\n", this.Name, this.absenceCount);
	}

	@Override
	public String toString() {
		return ("Name: " + this.getName() + "(" + this.absenceCount + "); ");
	}
}

class SeatingChart {
	/**
	 * seats[r][c] represents the Student in row r and column c in the classroom.
	 */
	private Student[][] seats;

	/**
	 * Creates a seating chart with the given number of rows and columns from the
	 * students in studentList. Empty seats in the seating chart are represented by
	 * null.
	 * 
	 * @param rows the number of rows of seats in the classroom
	 * @param cols the number of columns of seats in the classroom Precondition:
	 *             rows > 0; cols > 0; rows * cols >= studentList.size()
	 *             Postcondition: - Students appear in the seating chart in the same
	 *             order as they appear in studentList, starting at seats[0][0]. -
	 *             seats is filled column by column from studentList, followed by
	 *             any empty seats (represented by null). - studentList is
	 *             unchanged.
	 */
	// Answer for 2014 FRQ 3.(a)
	public SeatingChart(List<Student> studentList, int rows, int cols) {
		seats = new Student[rows][cols];
		int studentListIndex = 0;
		/*
		 * Looping vertically
		 */
		for (int j = 0; j < cols; j++) {
			for (int i = 0; i < rows; i++) {
				// if the index not reach end of studentList
				if (studentListIndex < studentList.size()) {
					seats[i][j] = studentList.get(studentListIndex);
					studentListIndex++;
				} // if
			} // for-i-loop
		} // for-j-loop
	}

	/**
	 * Removes students who have more than a given number of absences from the
	 * seating chart, replacing those entries in the seating chart with null and
	 * returns the number of students removed.
	 * 
	 * @param allowedAbsences an integer >= 0
	 * @return number of students removed from seats Postcondition: - All students
	 *         with allowedAbsences or fewer are in their original positions in seat
	 *         - No student in seats has more than allowedAbsences absences. -
	 *         Entries without students contain null.
	 */
	// Answer for 2014 FRQ 3.(b)
	public int removeAbsentStudents(int allowedAbsences) {
		int count = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (seats[i][j] != null && seats[i][j].getAbsenceCount() > allowedAbsences) {
					seats[i][j] = null;
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Print out the seat[][] array
	 */
	public void display () {
		System.out.println();
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (seats[i][j] != null)
					System.out.print(seats[i][j]);
				else
					System.out.print("NULL; ");
			} // for-j-loop
			System.out.println();
		} // for-i-loop
	} // End of display()

}
