package APCSA.FRQ._2011;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2011Q1 {
	public static void main(String[] args) {
		Sound s1 = new Sound(15, 4);
		s1.display();
		
		// Test for 2011 FRQ 1.(a)
		int count = s1.limitAmplitude(2000);
		s1.display();
		System.out.println("Number of Element Changed: " + count);
		
		// Test for 2011 FRQ 1.(b)
		s1.trimSilenceFromBeginning();
		s1.display();
	}
}

class Sound {
	/** the array of values in this sound; guaranteed not to be null */
	private int[] samples;
	
	public Sound(int size, int zero) {
		this.samples = new int[size];
		for (int i=0; i < this.samples.length; i++) {
			this.samples[i] = (int) (Math.random() * 7000) - 3500;
		}
		for (int i=0; i < zero; i++) {
			this.samples[i] = 0;
		}
	}

	/**
	 * Changes those values in this sound that have an amplitude greater than limit.
	 * Values greater than limit are changed to limit. Values less than -limit are
	 * changed to -limit.
	 * 
	 * @param limit the amplitude limit Precondition: limit ≥ 0
	 * @return the number of values in this sound that this method changed
	 */
	// Answer for 2011 FRQ 1.(a)
	public int limitAmplitude(int limit) {
		int count = 0;
		for(int i=0; i < this.samples.length; i++) {
			if (Math.abs(this.samples[i]) > limit) {
				this.samples[i] = (this.samples[i] > 0? limit: -limit);
				count++;
			}
		}
		return count;
	}

	/**
	 * Removes all silence from the beginning of this sound. Silence is represented
	 * by a value of 0. Precondition: samples contains at least one nonzero value
	 * Postcondition: the length of samples reflects the removal of starting silence
	 */
	// Answer for 2011 FRQ 1.(b)
	public void trimSilenceFromBeginning() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		boolean startCopy = false;
		for(int i=0; i < this.samples.length; i++) {
			if(this.samples[i] == 0 && !startCopy)
				continue;
			else {
				startCopy = true;
				temp.add(this.samples[i]);
			}	
		}
		
		int[] tempArray = new int[temp.size()];
		for(int i=0; i < tempArray.length; i++) {
			tempArray[i] = temp.get(i);
		}
	 
		this.samples = tempArray;
	}

	public void display() {
		for(int element: samples) {
			System.out.print(element + "; ");
		}
		System.out.println();
	}
}