package APCSA.FRQ._2003;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2003Q1 {
	public static void main(String[] args) {
		CollegeGroup group = new CollegeGroup();
		group.addCollegeList(new College("Colgate University", "Northeast", 27025));
		group.addCollegeList(new College("Duke University", "Southeast", 26000));
		group.addCollegeList(new College("Kalamazoo College", "Midwest", 19764));
		group.addCollegeList(new College("Stanford University", "West", 25917));
		group.addCollegeList(new College("Florida International University", "Southeast", 10800));
		group.addCollegeList(new College("Dartmouth College", "Northeast", 27764));
		group.addCollegeList(new College("Spelman College", "Southeast", 11455));
		group.addCollegeList(new College("Ethan College", "Southeast", 20000));
		group.addCollegeList(new College("Esmond College", "Southeast", 10000));
		group.display();
		
		// Test for 2003 FRQ 1.(a)
		group.UpdateTuition("Dartmouth College", "Northeast", 22000);
		group.UpdateTuition("Florida International University", "Southeast", 21000);
		
		// Test for 2003 FRQ 1.(b)
		ArrayList<College> list = group.getCollegeList("Southeast", 10000, 20000);
		for (College element: list)
			System.out.println(element);
	}
}

class College
{
	String name;
	String region;
	int tuition;
	
	public College(String name, String region, int tuition) {
		this.name = name;
		this.region = region;
		this.setTuition(tuition);
	}
	
	public int getTuition() {
		return this.tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}

	public String getName() {
		return this.name;
	}

	public String getRegion() {
		return this.region;
	}
	
	public String toString() {
		return String.format("%s at %s ($%d)", this.name, this.region, this.tuition);
	}
}

class CollegeGroup {
	private ArrayList<College> list;
	
	public CollegeGroup() {
		list = new ArrayList<College>();
	}
	
	public void addCollegeList(College c) {
		this.list.add(c);
	}
	
	/*
	 * Precondition: collegeName exists in this CollegeGroup
	 * Postcondition: tuition for collegeName is changed to newTuition
	 */
	// Answer for 2003 FRQ 1.(a)
	public void UpdateTuition(String newName, String newRegion, int newTuition) {
		for (int i=0; i < this.list.size(); i++) {
			if(this.list.get(i).getName() == newName && this.list.get(i).getRegion() == newRegion) {
				this.list.set(i, new College(newName, newRegion, newTuition));
			}
		}
	};
	
	/*
	 * Precondition: low <= high
	 * Postcondition: returns array of colleges in region
	 * where low <= tuition <= high;
	 * the size of the array returned is equal to the
	 * number of colleges that meet the criteria
	 */
	// Answer for 2003 FRQ 1.(b)
	public ArrayList<College> getCollegeList(String region, int low, int high) {
		ArrayList<College> filter = new ArrayList<College>();
		for (College element: this.list) {
			if(element.getTuition() >= low && element.getTuition() <= high && element.getRegion().equals(region)) {
				filter.add(element);
			}
		}
		
		return filter;
	}
	
	public void display() {
		for (College element: this.list)
			System.out.println(element);
		System.out.println("**********\n");
	}
};