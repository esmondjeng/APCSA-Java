package APCSA.FRQ._2005;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2005Q1 {
	public static void main(String[] args) {
		final int ARRAYSIZE = 6;
		Hotel h = new Hotel(ARRAYSIZE);
		Reservation[] r = new Reservation[ARRAYSIZE];
		
		// Test for 2005 FRQ 1.(a)
		r[0]=h.requestRoom("Esmond");
		r[1]=h.requestRoom("Ethan");
		r[2]=h.requestRoom("Jacqueline");
		r[3]=h.requestRoom("Jasmine");
		r[4]=h.requestRoom("Vivian");
		r[5]=h.requestRoom("Joseph");
		h.requestRoom("Jack");
		h.requestRoom("Joe");
		System.out.println(h);
		
		// Test for 2005 FRQ 1.(b)
		h.cancelAndReassign(r[1]);
		h.cancelAndReassign(r[3]);
		h.cancelAndReassign(r[5]);
		System.out.println(h);	
	}
}

class Reservation {
	String name;
	int room;

	public Reservation(String guestName, int roomNumber) {
		this.name = guestName;
		this.room = roomNumber;
	}

	public int getRoomNumber() {
		return this.room;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[Reservation Name: " + getName() + "; Room:  " + getRoomNumber() + "]";
	}
}

class Hotel {
	/*
	 * each element corresponds to a room in the hotel; if rooms[index] is null, the
	 * room is empty; otherwise, it contains a reference to the Reservation for that
	 * room, such that rooms[index].getRoomNumber() returns index
	 */
	private Reservation[] rooms;
	private ArrayList<String> waitList;
	
	public Hotel(int numOfRoom) {
		rooms = new Reservation[numOfRoom];
		waitList = new ArrayList<String>();
	}

	/*
	 * contains names of guests who have not yet been assigned a room because all
	 * rooms are full if there are any empty rooms (rooms with no reservation), then
	 * create a reservation for an empty room for the specified guest and return the
	 * new Reservation; otherwise, add the guest to the end of waitList and return
	 * null
	 */
	// Answer for 2005 FRQ 1.(a)
	public Reservation requestRoom(String guestName) {
		for (int i=0; i < rooms.length; i++) {
			if(rooms[i] ==null) { // If there is empty room
				rooms[i] = new Reservation(guestName, i);
				return rooms[i];
			}
		}
		// If there is no empty room
		waitList.add(guestName);
		return null;
	}

	/*
	 * release the room associated with parameter res, effectively canceling the
	 * reservation; if any names are stored in waitList, remove the first name and
	 * create a Reservation for this person in the room reserved by res; return that
	 * new Reservation; if waitList is empty, mark the room specified by res as
	 * empty and return null
	 * 
	 * precondition: res is a valid Reservation for some room in this hotel
	 */
	// Answer for 2005 FRQ 1.(b)
	public Reservation cancelAndReassign(Reservation res) { 
		rooms[res.getRoomNumber()] = null;
		if(waitList.size()>0) {
			return requestRoom(waitList.remove(0));
		} else {
			return null;
		}
	}
	
	public String toString() {
		String str = "";
		// Print reservations
		if (rooms.length > 0) {
			for(int i=0; i < rooms.length; i++) {
				if (rooms[i]!=null)
					str = str + String.format("%s\n", rooms[i]);
			}
				
			str = str + String.format("**********\n");
		} else {
			str = str + String.format("No guest reservation at all.\n");
		}

		// Print waiting list
		if (waitList.size() > 0) {
			for (int i=0; i < waitList.size(); i++)
				str = str + String.format("%s; ", waitList.get(i));
		} else {
			str = str + String.format("Empty waiting list.\n");
		}
		
		return str + "\n\n";
	}
}