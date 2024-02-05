package APCSA.FRQ._2010;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2010Q2 {
	public static void main(String[] args) {
		// Test1 for 2010 FRQ 2
		APLine line1 = new APLine(5, 4, -17);
		double slope1 = line1.getSlope(); // slope1 is assigned -1.25
		boolean onLine1 = line1.isOnLine(5, -2); // true because 5(5) + 4(-2) + (-17) = 0
		System.out.printf("Line1 slope = %5.2f, Online = %5b\n", slope1, onLine1);
		
		// Test2 for 2010 FRQ 2
		APLine line2 = new APLine(-25, 40, 30);
		double slope2 = line2.getSlope(); // slope2 is assigned 0.625
		boolean onLine2 = line2.isOnLine(5, -2); // false because -25(5) + 40(-2) + 30 ≠ 0
		System.out.printf("Line2 slope = %5.2f, Online = %5b\n", slope2, onLine2);
	}
}
// Answer for 2010 FRQ 2
class APLine {
	int a;
	int b;
	int c;
	
	public APLine(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double getSlope() {
		return - (double) this.a / (double) this.b;
	}
	
	public boolean isOnLine(double x, double y) {
		final double EPSILON = 1.0E-14;
		double check = (double) this.a * x + (double) this.b *y + (double) this.c;
		if (Math.abs(check) <= EPSILON) {
			return true;
		} else {
			return false;
		}
	}
}