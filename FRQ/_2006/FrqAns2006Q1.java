package APCSA.FRQ._2006;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FrqAns2006Q1 {
	public static void main(String[] args) {
		TimeInterval null1 = new TimeInterval(2021, 10, 5, 14, 30, 0, 2021, 10, 1, 12, 30, 0);
		TimeInterval null2 = new TimeInterval(2021, 10, 1, 12, 30, 0, 2021, 10, 1, 12, 30, 0);
		TimeInterval t1 = new TimeInterval(2021, 10, 1, 12, 30, 0, 2021, 10, 5, 14, 30, 0);
		TimeInterval t2 = new TimeInterval(2021, 10, 6, 12, 30, 0, 2021, 10, 7, 14, 30, 0);
		TimeInterval t3 = new TimeInterval(2021, 10, 4, 12, 30, 0, 2021, 10, 8, 14, 30, 0);
		System.out.println(null1);
		System.out.println(null1);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println("**********");
		// Test overlapsWith()
		System.out.println("t1 overlap t2: " + t1.overlapsWith(t2));
		System.out.println("t1 overlap t3: " + t1.overlapsWith(t3));
		System.out.println("t2 overlap t3: " + t2.overlapsWith(t3));
		System.out.println("**********");
		
		// Test for 2006 FRQ 1.(a)
		Appointment a1 = new Appointment(t1);
		Appointment a2 = new Appointment(t2);
		Appointment a3 = new Appointment(t3);
		System.out.println("a1 overlap a2: " + a1.conflictsWith(a2));
		System.out.println("a1 overlap a3: " + a1.conflictsWith(a3));
		System.out.println("a2 overlap a3: " + a2.conflictsWith(a3));
		System.out.println("**********");
		
		// Test for 2006 FRQ 1.(b) & 1.(c)
		DailySchedule schedule = new DailySchedule();
		schedule.addSchedule(a1);
		schedule.addSchedule(a2);
		schedule.addAppt(a3, false);
		schedule.display();
		System.out.println("**********");
		schedule.addAppt(a3, true);
		schedule.display();
		System.out.println("**********");
	}
}

class TimeInterval {
	private GregorianCalendar start;
	private GregorianCalendar end;
	
	public TimeInterval(int y1, int mon1, int d1, int h1, int m1, int s1, 
			int y2, int mon2, int d2, int h2, int m2, int s2) {
		this.start = new GregorianCalendar(y1, mon1-1, d1, h1, m1, s1); // start time
		this.end = new GregorianCalendar(y2, mon2-1, d2, h2, m2, s2); // end time
		
		if (this.start.compareTo(this.end) == -1) { // Right format, start is earlier
			// DEBUG: System.out.println("Right Format: " + this.start.compareTo(this.end));
		} else if (this.start.compareTo(this.end) == 1) { // Wrong format, start is late
			this.start = null;
			this.end = null;		
		} else { // (this.start.compareTo(this.end) == 0) // Wrong format start = end
			this.start = null;
			this.end = null;
		}
	}
	
	/*
	 * returns true if interval overlaps with this TimeInterval; otherwise, returns
	 * false
	 */
	public boolean overlapsWith(TimeInterval other) {
		boolean overlap = false;
		if (this.start.compareTo(other.start) == -1 && this.end.compareTo(other.start) == -1)
			overlap = false;
		if (other.start.compareTo(this.start) == -1 && other.end.compareTo(this.start) == -1)
			overlap = false;
		if (this.start.compareTo(other.start) == -1 && this.end.compareTo(other.start) == 1)
			overlap = true;
		if (other.start.compareTo(this.start) == -1 && other.end.compareTo(this.start) == 1)
			overlap = true;
		
		return overlap;
	}

	public String toString() {
		String str = "";
		if (this.start != null || this.end !=null) {
			str = str + String.format("Start time: %s\n", this.start.getTime());
			str = str + String.format("End time: %s", this.end.getTime());
			
		} else {
			str = "NULL";
		}
		
		return str;
	}
}

class Appointment {
	TimeInterval interval;
	
	public Appointment(TimeInterval interval) {
		this.interval = interval;
	}

	/*
	 * returns the time interval of this Appointment
	 */
	public TimeInterval getTime() {
		return this.interval;
	}

	/*
	 * returns true if the time interval of this Appointment overlaps with the time
	 * interval of other; otherwise, returns false
	 */
	// Answer for 2006 FRQ 1.(a)
	public boolean conflictsWith(Appointment other) {
		return this.getTime().overlapsWith(other.getTime());
	}

	public String toString() {
		return this.interval.toString();
	}
}

class DailySchedule {
	// contains Appointment objects, no two Appointments overlap
	private ArrayList<Appointment> apptList;

	public DailySchedule() {
		apptList = new ArrayList<Appointment>();
	}
	
	public void addSchedule(Appointment a) {
		this.apptList.add(a);
	}

	/*
	 * removes all appointments that overlap the given Appointment postcondition:
	 * all appointments that have a time conflict with appt have been removed from
	 * this DailySchedule
	 */
	// Answer for 2006 FRQ 1.(b)
	public void clearConflicts(Appointment appt) {
		int i = 0;
		while (i < apptList.size()) {
			if (appt.conflictsWith((Appointment) (apptList.get(i)))) {
				apptList.remove(i);
			} else {
				i++;
			}
		}
	}

	// Alternative Answer for 2006 FRQ 1.(b)
	public void clearConflicts2(Appointment appt) {
		for (int i = apptList.size() - 1; i >= 0; i--) {
			if (appt.conflictsWith((Appointment) apptList.get(i))) {
				apptList.remove(i);
			}
		}
	}

	/*
	 * if emergency is true, clears any overlapping appointments and adds appt to
	 * this DailySchedule; otherwise, if there are no conflicting appointments, adds
	 * appt to this DailySchedule; 
	 * 
	 * returns true if the appointment was added;
	 * otherwise, returns false
	 */
	// Answer for 2006 FRQ 1.(c)
	public boolean addAppt(Appointment appt, boolean emergency) {
		if (emergency) {
			clearConflicts(appt);
		} else {
			for (int i = 0; i < apptList.size(); i++) {
				if (appt.conflictsWith((Appointment) apptList.get(i))) {
					return false;
				}
			}
		}
		return apptList.add(appt);
	}
	
	public void display() {
		for (Appointment element: apptList)
			System.out.println(element);
	}
} // End of DailySchedule class