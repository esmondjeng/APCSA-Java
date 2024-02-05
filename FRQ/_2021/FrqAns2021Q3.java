package APCSA.FRQ._2021;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2021Q3 {
	public static void main(String[] args) {
		String[] name2000 = {"John", "Mary", "Kerry", "Ming"};
		String[] name2001 = {"Jack", "Minster", "Kash", "Jerry"};
		String[] name2002 = {"Tracy", "Hellen", "Dick", "Arthur"};
		String[] name2003 = {"Anson", "Frank", "Jessica", "Monica"};
		// Test for 2021 FRQ 3.(a)
		ClubMembers c = new ClubMembers();
		c.addMembers(name2000, 2000);
		c.addMembers(name2001, 2001);
		c.addMembers(name2002, 2002);
		c.addMembers(name2003, 2003);
		System.out.println(c);
		System.out.println("**********");
		
		// Test for 2021 FRQ 3.(b)
		ArrayList<MemberInfo> r = c.removeMembers(2001);
		System.out.println(c);
		System.out.println("----------");
		print1D(r);
	}
	
	public static void print1D(ArrayList<MemberInfo> member) {
		for(MemberInfo element : member)
			System.out.println(element);
	}
}

class MemberInfo {
	private String name;
	private int gradYear;
	private boolean hasGoodStanding;

	/**
	 * Constructs a MemberInfo object for the club member with name name, graduation
	 * year gradYear, and standing hasGoodStanding.
	 */
	public MemberInfo(String name, int year, boolean hasGoodStanding) {
		this.name = name;
		this.gradYear = year;
		this.hasGoodStanding = hasGoodStanding;
	}

	/** Returns the graduation year of the club member. */
	public int getGradYear() {
		return this.gradYear;
	}

	/** Returns true if the member is in good standing and false otherwise. */
	public boolean getGoodStanding() {
		return this.hasGoodStanding;
	}

	@Override
	public String toString() {
		return String.format("Name: %s (%d) Score: %s", this.name, getGradYear(),
				getGoodStanding() ? "Good" : "Below Average");
	}
}

class ClubMembers {
	private ArrayList<MemberInfo> memberList;

	public ClubMembers() {
		memberList = new ArrayList<MemberInfo>();
	}

	/**
	 * Adds new club members to memberList, as described in part (a). 
	 * Precondition: names is a non-empty array.
	 */
	// Answer for 2021 FRQ 3.(a)
	public void addMembers(String[] names, int gradYear) {
		for (String element: names)
			this.memberList.add(new MemberInfo(element, gradYear, true));
	}

	/**
	 * Removes members who have graduated and returns a list of members who have
	 * graduated and are in good standing, as described in part (b).
	 */
	// Answer for 2021 FRQ 3.(b)
	public ArrayList<MemberInfo> removeMembers(int year) {
		ArrayList<MemberInfo> removed = new ArrayList<MemberInfo>();
		
		for (int i=memberList.size()-1; i>=0; i--) {
			if (memberList.get(i).getGradYear() <= year) {
				if (memberList.get(i).getGoodStanding()) {
					removed.add(memberList.get(i));
				}
				memberList.remove(i);
			}
		}
		
		return removed;
	}

	@Override
	public String toString() {
		String str = "";
		for (MemberInfo element: memberList)
			str = str + element.toString() + "\n";
		return str;
	}
}