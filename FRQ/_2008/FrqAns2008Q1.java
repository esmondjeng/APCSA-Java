package APCSA.FRQ._2008;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2008Q1 {
	public static void main(String[] args) {
		// Test for 2008 FRQ 1.(a)
		Time t1 = new Time(); t1.setTime(12, 34, 0);
		Time t2 = new Time(); t2.setTime(14, 44, 0);
		Time t3 = new Time(); t3.setTime(8, 44, 0);
		Time t4 = new Time(); t4.setTime(15, 25, 0);
		Time t5 = new Time(); t5.setTime(16, 44, 0);
		Time t6 = new Time(); t6.setTime(19, 21, 0);
		System.out.println(t1.minutesUntil(t2));
		System.out.println(t1.minutesUntil(t3));
		System.out.println("**********");
		
		// Test for 2008 FRQ 1.(b)
		Trip myTrip = new Trip();
		myTrip.addFlight(new Flight(t3, t1));
		myTrip.addFlight(new Flight(t2, t4));
		myTrip.addFlight(new Flight(t5, t6));
		System.out.println("Shortest Transition: " + myTrip.getShortestLayover());
	}
}

class Time {
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	// set a new time value using universal time; throw an 
	// exception if the hour, minute or second is invalid
	public void setTime(int h, int m, int s) {
		// validate hour, minute and second
		if ((h >= 0 && h < 24) && (m >= 0 && m < 60) && (s >= 0 && s < 60)) {
			hour = h;
			minute = m;
			second = s;
		} // end if
		else
			throw new IllegalArgumentException("hour, minute and/or second was out of range");
	} // end method setTime

	/**
	* Input to calculate difference of minutes (seconds will be discarded)
	* @return difference, in minutes, between this time and other;
	* difference is negative if other is earlier than this time
	*/
	public int minutesUntil(Time other)
	{ 
		int d1 = this.hour*60 + this.minute;
		int d2 = other.hour*60 + other.minute;
		
		return (d2-d1);
	}
	
	
	// convert to String in universal-time format (HH:MM:SS)
	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	} // end method toUniversalString

	// Overridden toString() in standard-time format (H:MM:SS AM or PM)
	public String toString() {
		return String.format("%d:%02d:%02d %s", ((hour == 0 || hour == 12) ? 12 : hour % 12), minute, second,
				(hour < 12 ? "AM" : "PM"));
	} // end method toString
} // end class Time

class Flight {
	// arrivalTime will be later than departureTime
	Time departureTime;
	Time arrivalTime;
	
	public Flight(Time d, Time a) { // a > d by default
		this.departureTime = d;
		this.arrivalTime = a;
	}
	
	/**
	 * @return time at which the flight departs
	 */
	public Time getDepartureTime() {
		return this.departureTime;
	}

	/**
	 * @return time at which the flight arrives
	 */
	public Time getArrivalTime() {
		return this.arrivalTime;	
	}
}

class Trip {
	// stores the flights (if any) in chronological order
	private ArrayList<Flight> flights;
	
	public Trip() {
		flights = new ArrayList<Flight>();
	}
	
	// Added flight will be later than the last in the ArrayList
	public void addFlight(Flight f) {
		flights.add(f);
	}

	/**
	 * @return the number of minutes from the departure of the first flight to the
	 *         arrival of the last flight if there are one or more flights in the
	 *         trip; 0, if there are no flights in the trip
	 */
	// Answer for 2008 FRQ 1.(a)
	public int getDuration() {
		int size = flights.size();
		int diff = this.flights.get(0).getArrivalTime().minutesUntil(this.flights.get(size-1).getDepartureTime());
		return diff;
	}

	/**
	 * Precondition: the departure time for each flight is later than the arrival
	 * time of its preceding flight
	 * 
	 * @return the smallest number of minutes between the arrival of a flight and
	 *         the departure of the flight immediately after it, if there are two or
	 *         more flights in the trip; -1, if there are fewer than two flights in
	 *         the trip
	 */
	// Answer for 2008 FRQ 1.(b)
	public int getShortestLayover() {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i=0; i < (flights.size()-1); i++) {
			int diff = this.flights.get(i).getArrivalTime().minutesUntil(this.flights.get(i+1).getDepartureTime());
			if (diff < min)
				min = diff;
				index = i;
		}
		// DEBUG: System.out.printf("Shortest is between %d & %d = %d\n****\n", index, index+1, min);
		
		return min;
	}
}
