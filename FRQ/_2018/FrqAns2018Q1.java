package APCSA.FRQ._2018;

/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.Random;

public class FrqAns2018Q1 {
	public static void main(String[] args) {
		// Test for 2018 FRQ 1.(a) & FRQ 1.(b)
		FrogSimulation frog1 = new FrogSimulation(100, 5);
		System.out.println(frog1.simulate());
		System.out.println(frog1.runSimulations(100));
		
		// Test for 2018 FRQ 1.(a) & FRQ 1.(b)
		FrogSimulation frog2 = new FrogSimulation(200, 10);
		System.out.println(frog2.simulate());
		System.out.println(frog2.runSimulations(100));
	}
}

class FrogSimulation {
	/** Distance, in inches, from the starting position to the goal. */
	private int goalDistance;
	/** Maximum number of hops allowed to reach the goal. */
	private int maxHops;

	/**
	 * Constructs a FrogSimulation where dist is the distance, in inches, 
	 * from the starting position to the goal, and numHops is the maximum 
	 * number of hops allowed to reach the goal.
	 * 
	 * Precondition: dist > 0; numHops > 0
	 */
	public FrogSimulation(int dist, int numHops) {
		goalDistance = dist;
		maxHops = numHops;
	}

	/**
	 * Returns an integer representing the distance, in inches, to be 
	 * moved when the frog hops.
	 */
	private int hopDistance() {
		int max = 30;
		int min = 10;
		Random randomNumbers = new Random();
		int intValue = randomNumbers.nextInt(max-min+1);
		
		return (intValue + min);
	}

	/**
	 * Simulates a frog attempting to reach the goal as described in part (a).
	 * Returns true if the frog successfully reached or passed the goal 
	 * during the simulation; false otherwise.
	 */
	// Answer for 2018 FRQ 1.(a)
	public boolean simulate() {
		int position = 0;
		for (int count = 0; count < this.maxHops; count++) {
			position += hopDistance();
			if (position >= this.goalDistance) {
				return true;
			} else if (position < 0) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Runs num simulations and returns the proportion of simulations
	 * in which the frog successfully reached or passed the goal. 
	 * 
	 * Precondition: num > 0
	 */
	// Answer for 2018 FRQ 2.(b)
	public double runSimulations(int num) {
		int countSuccess = 0;
		for (int count = 0; count < num; count++) {
			if (simulate()) {
				countSuccess++;
			}
		}
		return (double) countSuccess / num;
	}
}