package APCSA.FRQ._2015;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2015Q4 {
	public static void main(String[] args) {
		// Test for 2015 FRQ 4.(b)
		Range group1 = new Range(-3, 2); // -3, -2, -1, 0, 1, 2
		System.out.println(group1);
		System.out.println(group1.contains(-5));	// false
		System.out.println(group1.contains(2));		// true
		// Test for 2015 FRQ 4.(c)
		MultipleGroups multiple1 = new MultipleGroups();
		multiple1.addRangeList(5,8);
		multiple1.addRangeList(10,12);
		multiple1.addRangeList(1,6);
		System.out.println(multiple1.contains(2));	// true
		System.out.println(multiple1.contains(9));	// false
		System.out.println(multiple1.contains(6));	// true
	}
}

//Answer for 2015 FRQ 4.(a)
interface NumberGroup {
	boolean contains(int num);
}

class Range implements NumberGroup {
	private int min;
	private int max;

	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	// Answer for 2015 FRQ 4.(b)
	public boolean contains(int num) {
		return num >= this.min && num <= this.max;
	}
	@Override
	public String toString() {
		String str;
		str = "Range(" + this.min + ", " + this.max + ")";
		return str;
	}
}

class MultipleGroups {
	private ArrayList<Range> groupList = new ArrayList<Range>();
	
	public void addRangeList(int min, int max) {
		this.groupList.add(new Range(min, max));
	}
	
	// Answer for 2015 FRQ 4.(c1)
	public boolean contains(int num) {
		for (Range g : this.groupList) {
			if (g.contains(num)) {
				return true;
			}
		}
		return false;
	}
	
	// Answer for 2015 FRQ 4.(c2)
	public boolean contains2(int num) {
		for (NumberGroup g : this.groupList) {
			if (g.contains(num)) {
				return true;
			}
		}
		return false;
	}
}