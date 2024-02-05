package APCSA.FRQ._2010;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2010Q3 {
	public static void main(String[] args) {
		int[] s1 = {100, 150, 105, 120, 90, 80, 50, 75, 75, 70, 80, 90, 100};
		Trail t1 = new Trail(s1);
		int[] s2 = {100, 150, 105, 150, 20, 80, 10, 75, 105, 70, 80, 90, 100};
		Trail t2 = new Trail(s2);
		int[] s3 = {100, 103, 105, 108, 110, 100, 110, 100, 95, 90, 80, 90, 100};
		Trail t3 = new Trail(s3);
		
		// Test for 2010 FRQ 3.(a)
		System.out.println(t1.isLevelTrailSegment(0, 12));
		System.out.println(t1.isLevelTrailSegment(4, 7));
		System.out.println(t1.isLevelTrailSegment(7, 10));
		System.out.println(t2.isLevelTrailSegment(0, 5));
		System.out.println(t3.isLevelTrailSegment(0, 5));
		System.out.println("********************");
		
		// Test for 2010 FRQ 3.(b)
		System.out.println(t1.isDifficult());
		System.out.println(t2.isDifficult());
		System.out.println(t3.isDifficult());
	}
}

class Trail {
	/**
	 * Representation of the trail. The number of markers on the trail is
	 * markers.length.
	 */
	private int[] markers;
	
	public Trail(int[] m) {
		int size = m.length;
		this.markers = new int[size];
		
		for (int i=0; i < size; i++) {
			this.markers[i] = m[i];
		}
	}

	/**
	 * Determines if a trail segment is level. A trail segment is defined by a
	 * starting marker, an ending marker, and all markers between those two markers.
	 * A trail segment is level if it has a difference between the maximum elevation
	 * and minimum elevation that is less than or equal to 10 meters.
	 * 
	 * @param start the index of the starting marker
	 * @param end   the index of the ending marker Precondition: 0 <= start < end <=
	 *              markers.length - 1
	 * @return true if the difference between the maximum and minimum elevation on
	 *         this segment of the trail is less than or equal to 10 meters; false
	 *         otherwise.
	 */
	// Answer for 2010 FRQ 3.(a)
	public boolean isLevelTrailSegment(int start, int end) {
		int max = Integer.MIN_VALUE; 
		int min = Integer.MAX_VALUE;
		for (int i=start; i <= end; i++) {
			if (this.markers[i] > max)
				max = this.markers[i];
			if (this.markers[i] < min)
				min = this.markers[i];
		}
		if ((max - min) <= 10)		
			return true;
		else
			return false;
	}

	/**
	 * Determines if this trail is rated difficult. A trail is rated by counting the
	 * number of changes in elevation that are at least 30 meters (up or down)
	 * between two consecutive markers. A trail with 3 or more such changes is rated
	 * difficult.
	 * 
	 * @return true if the trail is rated difficult; false otherwise.
	 */
	// Answer for 2010 FRQ 3.(b)
	public boolean isDifficult() {
		int count = 0;
		for (int i=0; i < this.markers.length-1 ;i++) {
			if(Math.abs(this.markers[i] - this.markers[i+1]) >= 30)
				count++;
		}
		if (count >= 3)
			return true;
		else
			return false;
	}
// There may be instance variables, constructors, and methods that are not shown.
}