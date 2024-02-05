package APCSA.FRQ._2017;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2017Q2 {
	public static void main(String[] args) {
		// Test for 2017 FRQ 2
		MultPractice m1 = new MultPractice(10, 20);
		System.out.println(m1.getProblem());
		m1.nextProblem();
		m1.nextProblem();
		System.out.println(m1.getProblem());
	}
}

interface StudyPractice {
	/** Returns the current practice problem. */
	String getProblem();

	/** Changes to the next practice problem. */
	void nextProblem();
}

// Answer for 2017 FRQ 2
class MultPractice implements StudyPractice {
	private int first;
	private int second;

	public MultPractice(int num1, int num2) {
		this.first = num1;
		this.second = num2;
	}

	public String getProblem() {
		return this.first + " TIMES " + this.second;
	}

	public void nextProblem() {
		this.second++;
	}
}