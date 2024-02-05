package APCSA.FRQ._2005;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.Arrays;

public class FrqAns2005Q4 {
	public static void main(String[] args) {
		int[] s1 = {50, 50, 20, 80, 53};	// Sorted scores
		int[] s2 = {20, 50, 50, 53, 80};	// Sorted scores
		int[] s3 = {20, 50, 50, 80};		// Sorted scores
		StudentRecord ss1= new StudentRecord(s1);
		StudentRecord ss2= new StudentRecord(s2);
		StudentRecord ss3= new StudentRecord(s3);
		// Test for 2005 FRQ 4.(a)(b)(c)
		System.out.println(ss1);
		System.out.println("S1 has improved? " + ss1.hasImproved());
		System.out.println("S1 normal average = " + ss1.average(0, s1.length-1));
		System.out.println("S1 normal average = " + ss1.finalAverage());
		System.out.println("**********");
		// Test for 2005 FRQ 4.(a)(b)(c)
		System.out.println(ss2);
		System.out.println("S2 has improved? " + ss2.hasImproved());
		System.out.println("S2 normal average = " + ss2.average(0, s2.length-1));
		System.out.println("S2 normal average = " + ss2.finalAverage());
		System.out.println("**********");
		// Test for 2005 FRQ 4.(a)(b)(c)
		System.out.println(ss1);
		System.out.println("S3 has improved? " + ss3.hasImproved());
		System.out.println("S3 normal average = " + ss3.average(0, s3.length-1));
		System.out.println("S3 normal average = " + ss3.finalAverage());
		System.out.println("**********");
	}
}

class StudentRecord {
	private int[] scores; // contains scores.length values
	
	public StudentRecord(int[] scores) {
		this.scores = new int[scores.length];
		for (int i=0; i < scores.length; i++) {
			this.scores[i] = scores[i];
		}
	}

	/*
	 * scores.length > 1 constructors and other data fields not shown returns the
	 * average (arithmetic mean) of the values in scores whose subscripts are
	 * between first and last, inclusive precondition: 0 <= first <= last <
	 * scores.length
	 */
	// Answer for 2005 FRQ 4.(a)
	public double average(int first, int last) {
		double num = last-first+1;
		double sum = 0.0;
		for (int i=first; i <= last; i++) {
			sum = sum + this.scores[i];
		}
		return sum / num;
	}

	/*
	 * returns true if each successive value in scores is greater than or equal to
	 * the previous value; otherwise, returns false
	 */
	// Answer for 2005 FRQ 4.(b)
	public boolean hasImproved() {
		boolean improved = true;
		for (int i=0; i < this.scores.length-1;i++) {
			if (this.scores[i] > this.scores[i+1])
				improved = false;
		}
		return improved;
	}

	/*
	 * if the values in scores have improved, returns the average of the elements in
	 * scores with indexes greater than or equal to scores.length/2; otherwise,
	 * returns the average of all of the values in scores
	 */
	// Answer for 2005 FRQ 3.(c)
	public double finalAverage() {
		if (hasImproved())
			return average(this.scores.length/2, this.scores.length-1);
		else
			return average(0, this.scores.length-1);
	}
	
	public String toString() {
		return Arrays.toString(this.scores);
	}
}