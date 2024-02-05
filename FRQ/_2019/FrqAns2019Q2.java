package APCSA.FRQ._2019;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2019Q2 {
	public static void main(String[] args) {
		// Test for 2019 FRQ 2
		StepTracker tr = new StepTracker(10000);
		System.out.println("Active Days = " + tr.activeDays());
		System.out.println("Avg Steps by day = " + tr.averageSteps());
		tr.addDailySteps(9000);
		tr.addDailySteps(5000);
		System.out.println("Active Days = " + tr.activeDays());
		System.out.println("Avg Steps by day = " + tr.averageSteps());
		tr.addDailySteps(13000);
		tr.addDailySteps(23000);
		System.out.println("Active Days = " + tr.activeDays());
		System.out.println("Avg Steps by day = " + tr.averageSteps());
		tr.addDailySteps(1111);
		System.out.println("Active Days = " + tr.activeDays());
		System.out.println("Avg Steps by day = " + tr.averageSteps());
	} // End of main()
} // End of FrqAns2019Q2

// Answer for 2019 FRQ 2
class StepTracker {
	private int minStepsforActive;
	private int countActiveDays;
	private int sumSteps;
	private int sumDays;
	
	// Construct for instantiation
	public StepTracker(int activeSteps) {
		this.minStepsforActive = activeSteps;
		this.countActiveDays = 0;
		this.sumSteps = 0;
		this.sumDays = 0;
	}
	
	public int activeDays() {
		return this.countActiveDays;
	}
	
	public double averageSteps() {
		if (sumDays >= 0)
			return (double)sumSteps / (double)sumDays;
		else
			return 0.0;
	}
	
	public void addDailySteps(int steps) {
		// Accumulate steps
		this.sumSteps = this.sumSteps + steps;
		// Accumulate days
		sumDays++;
		// Accumulate active days if exceeding min
		if (steps >= minStepsforActive) {
			countActiveDays++; // Increment active days if exceeding min
		}
	}
} // End of StepTracker class
