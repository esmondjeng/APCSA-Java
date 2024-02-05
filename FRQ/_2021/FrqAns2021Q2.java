package APCSA.FRQ._2021;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2021Q2 {
	public static void main(String[] args) {
		// Test for 2021 FRQ 2
		SingleTable t1 = new SingleTable(4, 74, 60.0);
		SingleTable t2 = new SingleTable(8, 64, 70.0);
		SingleTable t3 = new SingleTable(12, 75, 75.0);
		CombinedTable c1 = new CombinedTable(t1, t2);
		System.out.println(c1.canSeat(9));
		System.out.println(c1.canSeat(11));
		System.out.println(c1.getDesirability());
		System.out.println("**********");
		CombinedTable c2 = new CombinedTable(t2, t3);
		System.out.println(c2.canSeat(18));
		System.out.println(c2.getDesirability());
		t2.setViewQuality(80);
		System.out.println(c2.getDesirability());
		System.out.println("**********");
	}
}

class SingleTable {
	private int numSeats;
	private int height;
	private double viewQuality;

	public SingleTable(int num, int height,	double quality) {
		if ((num >= 4) && (height > 0) && (quality > 0.0)) {
			this.numSeats = num;
			this.height = height;
			this.viewQuality = quality;
		}
		else {
			throw new IllegalArgumentException("Wrong  seatNum, height"
					+ "；错误的数字内容");
		}
	}
	/**
	 * Returns the number of seats at this table. The value is >= 4
	 */
	public int getNumSeats() {
		return this.numSeats;
	}

	/** Returns the height of this table in centimeters. */
	public int getHeight() {
		return this.height;
	}

	/** Returns the quality of the view from this table. */
	public double getViewQuality() {
		return this.viewQuality;
	}

	/** Sets the quality of the view from this table to value . */
	public void setViewQuality(double value) {
		this.viewQuality = value;
	}
}

// Answer for 2021 FRQ 2
class CombinedTable {
	SingleTable t1;
	SingleTable t2;
	
	public CombinedTable(SingleTable t1, SingleTable t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public boolean canSeat(int num) {
		int numSeat = this.t1.getNumSeats()+this.t2.getNumSeats()-2;
		if (num > numSeat)
			return false;
		else
			return true;
	}
	
	public double getDesirability() {
		if (t1.getHeight() == t2.getHeight()) {
			return (this.t1.getViewQuality() + this.t2.getViewQuality())/2.0;
		} else {
			return (this.t1.getViewQuality() + this.t2.getViewQuality())/2.0 - 10.0;
		}
		
	}
	
}