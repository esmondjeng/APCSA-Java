package APCSA.FRQ._2012;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2012Q3 {
	public static void main(String[] args) {
		HorseBarn hb = new HorseBarn(7);
		hb.setBarnSpace(0, "Trigger", 1340);
		hb.setBarnSpace(2, "Silver", 1210);
		hb.setBarnSpace(3, "Lasy", 1545);
		hb.setBarnSpace(5, "Patches", 1350);
		hb.setBarnSpace(6, "Duke", 1410);
		hb.display();
		System.out.println("**********");
		
		// Test for 2012 FRQ 3.(a)
		System.out.println("Found Index: " + hb.findHorseSpace("Trigger"));
		System.out.println("Found Index: " + hb.findHorseSpace("Silver"));
		System.out.println("Found Index: " + hb.findHorseSpace("Coco"));
		System.out.println("**********");
		
		// Answer for 2012 FRQ 3.(b)
		hb.consolidate();
		hb.display();
	}
}

interface HorseTemplate {
	/** @return the horse's name */
	String getName();

	/** @return the horse's weight */
	int getWeight();
	// There may be methods that are not shown.
}

class Horse implements HorseTemplate {
	String name;
	int weight;
	
	public Horse(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return ("Horse: " + this.name + "(" + this.weight + "); ");
	}
}

class HorseBarn {
	/**
	 * The spaces in the barn. Each array element holds a reference to the horse
	 * that is currently occupying the space. A null value indicates an empty space.
	 */
	private Horse[] spaces;
	
	public HorseBarn(int size) {
		this.spaces = new Horse[size];
		for (int i=0; i<spaces.length; i++) {
			this.spaces[i] = null;
		}
	}
	
	public void setBarnSpace(int index, String name, int weight) {
		this.spaces[index] = new Horse(name, weight);
	}

	/**
	 * Returns the index of the space that contains the horse with the specified
	 * name. Precondition: No two horses in the barn have the same name.
	 * 
	 * @param name the name of the horse to find
	 * @return the index of the space containing the horse with the specified name;
	 *         -1 if no horse with the specified name is in the barn.
	 */
	// Answer for 2012 FRQ 3.(a)
	public int findHorseSpace(String name) {
		int foundIndex = -1;
		for (int i=0; i<this.spaces.length; i++) {
			if (this.spaces[i] == null)
				continue;
			if(this.spaces[i].getName().equals(name)) {
				foundIndex = i;
				break;
			}
		}
		
		return foundIndex;
	}

	/**
	 * Consolidates the barn by moving horses so that the horses are in adjacent
	 * spaces, starting at index 0, with no empty space between any two horses.
	 * Postcondition: The order of the horses is the same as before the
	 * consolidation.
	 */
	// Answer for 2012 FRQ 3.(b)
	public void consolidate() {
		/*
		 * Temporary ArrayList to store nun-null element
		 */
		ArrayList<Horse> temp = new ArrayList<Horse>();
		for(Horse element: this.spaces) {
			if (element != null) {
				temp.add(element);
			}
		}
		
		int counter = 0;
		/*
		 * Add to Array from temporary ArrayList
		 */
		for (int i=0; i<this.spaces.length; i++) {
			if (i < temp.size())
				this.spaces[i] = temp.get(counter++);
			else
				this.spaces[i] = null; // No ArrayList element, so null
		}
	}
	
	public void display() {
		for(Horse element: this.spaces) {
			System.out.println(element);
		}
	}
}