package APCSA.FRQ._2012;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.List;

public class FrqAns2012Q1 {
	public static void main(String[] args) {
		// Test for 2012 FRQ 1.(a)
		ClimbingClub Esmond = new ClimbingClub();
		Esmond.addClimb("Jack", 120);
		Esmond.addClimb("Zombie", 293);
		Esmond.addClimb("Luwenskii", 441);
		Esmond.addClimb("Chamber", 310);
		Esmond.addClimb("Horizon", 110);
		Esmond.addClimb("Luwenskii", 350);
		Esmond.addClimb("Dick", 320);
		Esmond.display();
		System.out.println("**********");

		// Test for 2012 FRQ 1.(b)
		ClimbingClub Ethan = new ClimbingClub();
		Ethan.addClimbSort("Luwenskii", 120);
		Ethan.addClimbSort("Zombie", 293);
		Ethan.addClimbSort("Luwenskii", 441);
		Ethan.addClimbSort("Chamber", 310);
		Ethan.addClimbSort("Horizon", 110);
		Ethan.addClimbSort("Luwenskii", 350);
		Ethan.addClimbSort("Dick", 320);
		Ethan.display();
		System.out.println("**********");
		
		// Test for 2012 FRQ 1.(c)
		/* Calling with unsorted object arrayList */
		System.out.println("Disctinct Name Number: " + Esmond.distinctPeakNames()); // Test for 2012 FRQ 1.(d)(i) No
		/* Calling with Sorted object arrayList */
		System.out.println("Disctinct Name Number: " + Ethan.distinctPeakNames()); // Test for 2012 FRQ 1.(d)(ii) Yes
	}
}

class ClimbInfo {
	String peakName;
	int climbTime;
	
	/**
	 * Creates a ClimbInfo object with name peakName and time climbTime.
	 * 
	 * @param peakName  the name of the mountain peak
	 * @param climbTime the number of minutes taken to complete the climb
	 */
	public ClimbInfo(String peakName, int climbTime) {
		this.peakName = peakName;
		this.climbTime = climbTime;
	}

	/**
	 * @return the name of the mountain peak
	 */
	public String getName() {
		return this.peakName;
	}

	/**
	 * @return the number of minutes taken to complete the climb
	 */
	public int getTime() {
		return this.climbTime;
	}
	
	@Override
	public String toString() {
		return ("Peak Name: " + this.peakName + "(" + this.climbTime + "); ");
	}
}

class ClimbingClub {
	/**
	 * The list of climbs completed by members of the club. Guaranteed not to be
	 * null. Contains only non-null references.
	 */
	private List<ClimbInfo> climbList;

	/** Creates a new ClimbingClub object. */
	public ClimbingClub() {
		climbList = new ArrayList<ClimbInfo>();
	}

	/**
	 * Adds a new climb with name peakName and time climbTime to the list of climbs.
	 * 
	 * @param peakName  the name of the mountain peak climbed
	 * @param climbTime the number of minutes taken to complete the climb
	 */
	// Answer for 2012 FRQ 1.(a)
	public void addClimb(String peakName, int climbTime) {
		/*
		 * to be implemented in part (a) with ClimbInfo objects in the order they were added
		 */
		this.climbList.add(new ClimbInfo(peakName, climbTime));
	}
	// Answer for 2012 FRQ 1.(b)
	public void addClimbSort(String peakName, int climbTime) {
		/*
		 * to be implemented in part (b) with ClimbInfo objects in alphabetical order by name
		 */
		boolean found = false;
		int foundIndex = -999;
		for(int i=0; i < this.climbList.size(); i++) {
			if (climbList.get(i).getName().compareTo(peakName) > 0) {
				found = true;
				foundIndex = i;
				break;
			}
		}
		if (found)
			this.climbList.add(foundIndex, new ClimbInfo(peakName, climbTime));
		else
			this.climbList.add(new ClimbInfo(peakName, climbTime));
	}

	/** 
	 * @return the number of distinct names in the list of climbs
	 */
	/*
	 * to be answered in part (c) must be sorted before imput
	 */
	// Answer for 2012 FRQ 1.(c)
	public int distinctPeakNames() {
		if (climbList.size() == 0) {
			return 0;
		}
		ClimbInfo currInfo = climbList.get(0);
		String prevName = currInfo.getName();
		String currName = null;
		int numNames = 1;
		for (int i = 1; i < climbList.size(); i++) {
			currInfo = climbList.get(i);
			currName = currInfo.getName();
			if (prevName.compareTo(currName) != 0) { // 
				numNames++;
				prevName = currName;
			}
		}
		return numNames;
	}

	public void display() {
		for(int i=0; i < this.climbList.size(); i++) {
			System.out.println(climbList.get(i));
		}
	}
	// There may be instance variables, constructors, and methods that are not shown.
}