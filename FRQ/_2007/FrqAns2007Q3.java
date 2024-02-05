package APCSA.FRQ._2007;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2007Q3 {
	public static void main(String[] args) {
		// Test for 2007 FRQ 3.(a)
		String[] s1 = { "C", "B", "?", "D", "A", "?", "C", "B", "A", "B" }; // C-6, Null-2, W-2
		String[] s2 = { "A", "C", "A", "D", "A", "B", "C", "C", "A", "B" }; // C-7, Null-0, W-3
		String[] s3 = { "A", "B", "?", "D", "A", "B", "C", "D", "A", "B" }; // C-9, Null-1, W-0
		String[] aa = { "A", "B", "C", "D", "A", "B", "C", "D", "A", "B" };
		ArrayList<String> answers = new ArrayList<String>();
		for (int i = 0; i < aa.length; i++) {
			answers.add(aa[i]);
		}
		StudentAnswerSheet best = new StudentAnswerSheet("BEST", aa);
		StudentAnswerSheet as1 = new StudentAnswerSheet("John", s1);
		StudentAnswerSheet as2 = new StudentAnswerSheet("Mary", s2);
		StudentAnswerSheet as3 = new StudentAnswerSheet("Greg", s3);
		System.out.println("Full Score: " + best.getScore(answers)); // 10*1
		System.out.println("John's Score: " + as1.getScore(answers)); // 6-(2*0.25) = 5.5
		System.out.println("Mary's score: " + as2.getScore(answers)); // 7-(3*0.25) = 6.25
		System.out.println("Greg's score: " + as3.getScore(answers)); // 9
		System.out.println("**********");

		// Test for 2007 FRQ 3.(b)
		ArrayList<StudentAnswerSheet> s = new ArrayList<StudentAnswerSheet>();
		s.add(as1);
		s.add(as2);
		s.add(as3);
		// s.add(best);
		TestResults testResult = new TestResults(s);
		System.out.println(testResult.highestScoringStudent(answers));
	}
}

class StudentAnswerSheet {
	String name;
	private ArrayList<String> answers; // the list of the student's answers

	public StudentAnswerSheet(String name, String[] str) {
		this.answers = new ArrayList<String>();
		this.name = name;
		for (int i = 0; i < str.length; i++) {
			answers.add(str[i]);
		}
	}

	/**
	 * @param key the list of correct answers, represented as strings of length one
	 *            Precondition: key.size() is equal to the number of answers in this
	 *            answer sheet
	 * @return this student's test score
	 */
	// Answer for 2007 FRQ 3.(a)
	public double getScore(ArrayList<String> key) { /* to be implemented in part (a) */
		double score = 0.0;
		int size = this.answers.size();
		for (int i = 0; i < size; i++) {
			if (this.answers.get(i).equals("?"))
				continue;
			if (this.answers.get(i).equals(key.get(i))) {
				score = score + 1.0;
			} else {
				score = score - 0.25;
			}
		}
		return score;
	}

	/**
	 * @return the name of the student
	 */
	public String getName() {
		return this.name;
	}
}

class TestResults {
	private ArrayList<StudentAnswerSheet> sheets;
	
	public TestResults(ArrayList<StudentAnswerSheet> sheets) {
		this.sheets = new ArrayList<StudentAnswerSheet>();
		this.sheets = sheets;
	}

	/**
	 * Precondition: sheets.size() > 0 ; all answer sheets in sheets have the same
	 * number of answers
	 * 
	 * @param key the list of correct answers represented as strings of length one
	 * Precondition: key.size() is equal to the number of answers in each
	 *               of the answer sheets in sheets
	 * @return the name of the student with the highest score
	 */
	// Answer for 2007 FRQ 3.(b)
	public String highestScoringStudent(ArrayList<String> key) {
		if (this.sheets.size() <= 0)
			return null;
		double max = (double) Integer.MIN_VALUE;
		int maxIndex = Integer.MIN_VALUE;;
		for (int i = 0; i < this.sheets.size(); i++) {
			double tempScore = this.sheets.get(i).getScore(key);
			if (tempScore > max) {
				max = tempScore;
				maxIndex = i;
			}
		}
		
		return sheets.get(maxIndex).getName();
	}
}